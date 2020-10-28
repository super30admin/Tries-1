# INSERT METHOD TAKES O(N**2) TIME WHERE N IS LEN(WORD)
# SEARCH METHOD TAKES O(N) TIME WHERE N IS LEN(WORD)
# STARTSWITH METHOD TAKES O(P) TIME WHERE P IS LEN(PREFIX)
 
class Trie:
    def __init__(self):
        self.root = {}
 
    def insert(self, word: str) -> None:
        current = self.root
        for char in word:
            if char not in current:
                current[char] = {}
            current = current[char]
        current["*"] = word
        

    def search(self, word: str) -> bool:
        current = self.root
        for char in word:
            if char not in current:
                return False
            current = current[char]
        return True if "*" in current else False
        

    def startsWith(self, prefix: str) -> bool:
        current = self.root
        for char in prefix:
            if char not in current:
                return False
            current = current[char]
        return True