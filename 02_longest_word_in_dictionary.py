class TrieNode:
    def __init__(self):
        self.children = {}
        self.isWord = False
    
    def createAndGetChildNode(self,ch):
        
        if ch not in self.children:
            self.children[ch] = TrieNode()
        
        return self.children[ch]
    
    def setWord(self):
        self.isWord = True
        
    def isWordPresent(self):
        return self.isWord
        
    def getChild(self, ch):
        return self.children[ch]
        
class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self,word):
        curr = self.root
        
        for ch in word:
            curr = curr.createAndGetChildNode(ch)
        
        curr.setWord()
    
    def search(self,word):
        curr = self.root
        
        for ch in word:
            curr = curr.getChild(ch)
            if not (curr) or not (curr.isWordPresent()):
                return False
        
        return True
    
    

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        
        for word in words:
            trie.insert(word)
        
        ans = ""
        
        for word in words:
            if len(word) > len(ans) or (len(ans) == len(word) and word < ans):
                if trie.search(word):
                    ans = word
                    
        return ans
        