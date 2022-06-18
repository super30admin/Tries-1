#Time Complexity: O(nk)
#Space Complexity: O(nk)
class Solution:
    
    class Trie:
        def __init__(self):
            self.isEnd = False
            self.lst = [None]*26
     
    def insertWords(self, word):
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            idx = ord(c) - ord('a')
            if curr.lst[idx] == None:
                curr.lst[idx] = self.Trie()
            curr = curr.lst[idx]
        curr.isEnd = True
            
    def dfs(self,curr,path):
        if curr == None:
            return
        
        if len(path)>len(self.result):
            self.result = path.copy()
            
        for i in range(26):
            path.append(chr(ord('a')+i))
            if curr.lst[i] != None and curr.lst[i].isEnd == True:
                self.dfs(curr.lst[i],path)
            path.pop()
        
    def longestWord(self, words: List[str]) -> str:
        self.root = self.Trie()
        self.result = []
        for word in words:
            self.insertWords(word)
        self.dfs(self.root,[])
        return "".join(self.result)