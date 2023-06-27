class TrieNode:
    def __init__(self):
        self.childern = {}
        self.endOfWord = False

class Trie:

    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word: str) -> None:
        curr = self.root
        
        for c in word:
            if c not in curr.childern:
                curr.childern[c] = TrieNode()
            curr = curr.childern[c]
        
        curr.endOfWord = True
        

    def search(self, word: str) -> bool:
        curr = self.root
        
        for c in word:
            if c not in curr.childern:
                return False
            curr = curr.childern[c]
        
        return curr.endOfWord
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        
        for c in prefix:
            if c not in curr.childern:
                return False
            curr = curr.childern[c]
        return True
        
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)