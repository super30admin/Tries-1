class Cell:
    def __init__(self):
        self.arr = [None for _ in range(26)] 
        self.end = False

class Trie:

    def __init__(self):
        self.trie = Cell()

    def insert(self, word: str) -> None:
        curr = self.trie
        for i in word:
            idx = 97-ord(i)
            if(curr.arr[idx]==None):
                curr.arr[idx] = Cell()
            curr = curr.arr[idx]
        curr.end = True
            
        
    def search(self, word: str) -> bool:
        curr = self.trie
        for i in word:
            idx = 97-ord(i)
            if(curr.arr[idx]==None):
                return False
            curr = curr.arr[idx]
        return curr.end

    def startsWith(self, prefix: str) -> bool:
        curr = self.trie
        for i in prefix:
            idx = 97-ord(i)
            if(curr.arr[idx]==None):
                return False
            curr = curr.arr[idx]
        return True
        

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)