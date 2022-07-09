#Time complexity: O(nk)
#space complexity: O(1)

class TrieNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isEnd = False
        
class Solution:
    def insert(self, word):
        curr = self.root
        for i in range(len(word)):
            if curr.children[ord(word[i])-ord('a')] is None:
                curr.children[ord(word[i])-ord('a')] = TrieNode()
            curr = curr.children[ord(word[i])-ord('a')] 
        curr.isEnd = True
        
    def longestWord(self, words: List[str]) -> str:
        self.root = TrieNode()
        for word in words:
            self.insert(word)
        self.maxStr = ""
        self.backtrack(self.root, [])
        return self.maxStr
    
    def backtrack(self, curr, currStr):
        if len(currStr) > len(self.maxStr):
            print(currStr)
            self.maxStr = str(''.join(currStr))
        
        for i in range(26):
            if curr.children[i] is not None and curr.children[i].isEnd:
                currStr.append(chr(i + ord('a')))
                self.backtrack(curr.children[i], currStr)
                del currStr[-1]
