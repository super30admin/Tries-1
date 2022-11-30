#Time Complexity - O(nl)
#Space Complexity - O(nl)
class Trie:

    def __init__(self):
        self.trie = [None] * 27

    def insert(self, word: str) -> None:
        t = self.trie
        for x in word:
            num = ord(x) - ord('a')
            if t[num] == None:
                t[num] = [None] * 27
            t = t[num]
        t[26] = True
    
    def search(self, word: str) -> bool:
        t = self.trie
        for x in word:
            num = ord(x) - ord('a')
            if t[num] == None:
                return False
            t = t[num]
        return t[26] != None
        
    def startsWith(self, prefix: str) -> bool:
        t = self.trie
        for x in prefix:
            num = ord(x) - ord('a')
            if t[num] == None:
                return False
            t = t[num]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)