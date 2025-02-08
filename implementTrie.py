class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False

class Trie:
    
    def __init__(self):
        self. root = TrieNode()
        

    def insert(self, word: str) -> None:
        # TC : O(n) -- length of word
        cur = self.root
        for ch in word:
            i = ord(ch)-ord('a')
            if cur.children[i] == None:
                cur.children[i] = TrieNode()
            cur = cur.children[i]
        cur.isEnd = True


    def search(self, word: str) -> bool:
        # TC : O(n) -- length of word
        cur = self.root
        for ch in word:
            i=ord(ch)-ord('a')
            if cur.children[i] == None:
                return False
            cur = cur.children[i]
        return cur.isEnd
       
        

    def startsWith(self, prefix: str) -> bool:
        # TC : O(n) -- length of prefix
        cur = self.root
        for ch in prefix:
            i = ord(ch)-ord('a')
            if cur.children[i] == None:
                return False
            cur = cur.children[i]
        return True

        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)