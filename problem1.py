#Time complexity O(n), space O(n)

#Trie node creation
class TrieNode:
     def __init__(self):
        self.children={}
        self.isEnd=False


class Trie:
#Initialize Trie node
    def __init__(self):
        self.root = TrieNode()
 
#Searching and inserting if not present
    def insert(self, word: str) -> None:
        cur=self.root
        
        for i in word:
            if i not in cur.children:
                cur.children[i] = TrieNode()
            cur = cur.children[i]
        cur.isEnd=True
  
#Searching and returning
    def search(self, word: str) -> bool:
        cur = self.root
        
        for i in word:
            if i not in cur.children:
                return False
            cur=cur.children[i]
        if cur.isEnd:
            return True
        
        return False

#Searching and returning    
    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        
        for i in prefix:
            if i not in cur.children:
                return False
            cur = cur.children[i]
            
        return True
