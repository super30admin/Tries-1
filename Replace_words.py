# Time Complexity : O(M * L + N * L) where M is the number of words in dictionary, N is number of words in sentence and L is the average word length
# Space Complexity : O(M * L + N * L) for tries and split array.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Build a Trie by inserting all dictionary roots, marking the end of each root with isEnd = True.
# For each sentence word, traverse the Trie until a character is missing or the shortest matching root is found.
# Replace the word with the matching root if found; otherwise keep the original word, then join all words into a sentence.

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        currentNode = self.root
        for i in range(len(word)):
            ch = word[i]
            if ch not in currentNode.children:
                currentNode.children[ch] = TrieNode()
            currentNode = currentNode.children[ch]
        currentNode.isEnd = True

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        splitArr = sentence.split(" ")
        result = []
        for word in dictionary:
            trie.insert(word)
        for i in range(len(splitArr)):
            word = splitArr[i]
            currentNode = trie.root
            replacement = ""
            for ch in word:
                if ch not in currentNode.children or currentNode.isEnd:
                    break
                replacement += ch
                currentNode = currentNode.children[ch]
            if currentNode.isEnd:
                result.append(replacement)
            else:
                result.append(word)
        return " ".join(result)




        
    
