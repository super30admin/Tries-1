# // Time Complexity : O(n) here n is lengthj of the sentence
# // Space Complexity : O(n) where n is size of trie
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : Followed approach from class
#Replace Words
class TrieNode:
    def __init__(self, char):
        self.char = char
        self.children = [None] * 26
        self.isWord = False

class Solution:

    def __init__(self):
        self.trie = TrieNode("0")

    def insert(self, word):
        t = self.trie
        for char in word:
            childIdx = ord(char) - ord('a')
            if not t.children[childIdx]:
                newNode = TrieNode(char)
                t.children[childIdx] = newNode

            t = t.children[childIdx]

        t.isWord = True

    def findRoot(self, word):
        t = self.trie
        root_word = []
        for char in word:
            root_word.append(t.char)
            childIdx = ord(char) - ord('a')
            if not t.children[childIdx] or t.isWord:
                break
            t = t.children[childIdx]   
        if t.isWord:
            return "".join(root_word[1:])
        return ""

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:

        for word in dictionary: 
            self.insert(word) 

        sentWords = sentence.split(" ")
        result = []

        for word in sentWords: 
            curr_root = self.findRoot(word) 
            if not curr_root:
                result.append(word)

            else:
                result.append("".join(curr_root))

        return " ".join(result) 
