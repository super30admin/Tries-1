#  Time Complexity : O(M * L + N * L)
#  Space Complexity : O(M * L + N * L)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code solves the Replace Words problem using a Trie. It first inserts all dictionary root words into the Trie, then for each word in the sentence, it traverses the Trie to find the shortest root that can replace it (stopping early if a root word ends). Finally, it builds a new sentence where each word is replaced by its shortest dictionary root if possible, otherwise kept as is.


class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None] * 26
            self.isEnd = False
        
    def __init__(self):
        self.root = self.TrieNode()
    
    def insert(self, word):
        curr = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if not curr.children[idx]:
                curr.children[idx] = self.TrieNode()
            curr = curr.children[idx]
        curr.isEnd = True
    
    def getShortestVersion(self, word):
        curr = self.root
        sb = []

        for c in word:
            idx = ord(c) - ord('a')
            if not curr.children[idx] or curr.isEnd:
                break
            sb.append(c)
            curr = curr.children[idx]
        
        if curr.isEnd:
            return ''.join(sb)
        
        return word

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
            self.insert(word)
        
        splitArr = sentence.split(" ")
        result = []

        for i in range(len(splitArr)):
            word = splitArr[i]
            result.append(self.getShortestVersion(word))
        
        return " ".join(result)