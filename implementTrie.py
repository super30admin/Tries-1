
class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isEnd = None
        
        
class Trie:
    def __init__(self):
        self.root = TrieNode()
        self.charA = ord('a')
        
    def insert(self, word: str) -> None:
        curr = self.root
        charA = self.charA
        
        for ch in word:
            if curr.children[ord(ch)-charA] == None:
                curr.children[ord(ch)-charA] = TrieNode()
            curr = curr.children[ord(ch)-charA]
        curr.isEnd = True

        
    def search(self, word: str) -> bool:
        curr = self.root
        charA = self.charA
        
        for ch in word:
            if curr.children[ord(ch)-charA] == None:
                return False
            curr = curr.children[ord(ch)-charA]
        return curr.isEnd

    
    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        charA = self.charA
        
        for ch in prefix:
            if curr.children[ord(ch)-charA] == None:
                return False
            curr = curr.children[ord(ch)-charA]
            
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)