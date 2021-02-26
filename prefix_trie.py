# O(N) TIME AND O(N) FOR INSERT,SEARCH, STARTSWITH WHERE N IS LEN(WORD)

class Trie:
    def __init__(self):
        self.root = {}
        
    def insert(self, word: str) -> None:
        current = self.root
        for char in word:
            if char not in current:
                current[char] = {}
            current = current[char]
        current["*"] = True
        
    def search(self, word: str) -> bool:
        current = self.root
        for char in word:
            if char not in current:
                return False
            current = current[char]
        return "*" in current
        
    def startsWith(self, prefix: str) -> bool:
        current = self.root
        for char in prefix:
            if char not in current:
                return False
            current = current[char]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)