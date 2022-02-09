class TrieNode():
    
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False 
        self.ch = None

class Trie():
    root = None
    def __init__(self):    
        self.root = TrieNode() 
    
    def insert(self, word):
        curr = self.root
        for c in word:
            index = ord(c) - ord('a')
            if not curr.children[index] :
                curr.children[index] = TrieNode()
            
            curr = curr.children[index] 
            curr.ch = c
        curr.isEnd = True
    
class Solution:
    
    result = ""
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        self.result = ""
        for word in words:
            trie.insert(word)
        
    
        self.backtrack(trie.root, "")
        return self.result
    
    
    def backtrack(self, root, path):
        # base
        if(len(path) >= len(self.result)):
            self.result = path
            
        # logic
        length = len(path)
        for i in range(25,-1,-1):
            if root.children[i] != None and root.children[i].isEnd:
                # action
                path += root.children[i].ch
                # recurse
                self.backtrack(root.children[i], path)
                # backtrack
                path = path[:length]
             
            
            
        
        