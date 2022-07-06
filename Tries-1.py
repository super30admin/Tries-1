# TC/SC: O(M)/O(M)
class Trie:

    def __init__(self):
        self.trieStorage = {}
        self.endCharacter = '*'
        

    def insert(self, word: str) -> None:
        node = self.trieStorage
        for i in word:
            if i not in node:
                node[i] = {}
            node = node[i]
        
        node[self.endCharacter] = True
                
        
    def search(self, word: str) -> bool:
        node = self.trieStorage
        for i in word:
            if i not in node:
                return False
            node = node[i]
        
        return self.endCharacter in node
        

    def startsWith(self, word: str) -> bool:
        node = self.trieStorage
        for i in word:
            if i not in node:
                return False
            node = node[i]
        
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
