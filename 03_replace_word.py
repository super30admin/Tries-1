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
        if ch in self.children:
            return self.children[ch]
        return None
        
class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self,word):
        curr = self.root
        
        for ch in word:
            curr = curr.createAndGetChildNode(ch)
        
        curr.setWord()
    
    def prefix(self,word):
        curr = self.root
        
        for i in range(len(word)):
            
            ch = word[i]
            curr = curr.getChild(ch)
            if not curr:
                break
            if curr.isWordPresent():
                return word[0:i+1]
        
        return None

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        
        for word in dictionary:
            trie.insert(word)
        
        words = sentence.split()
        
        for i in range(len(words)):
            word = words[i]
            root = trie.prefix(word);
            words[i] = word if root==None else root;
        
        return ' '.join(words)
            
            
        