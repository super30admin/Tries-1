class TrieNode:
    def __init__(self):
        self.chars = dict()
        self.isEnd = False

class Trie:

    def __init__(self):
        self.Trie = TrieNode()

    def insert(self, word: str) -> None:
        cur = self.Trie
        i = 0
        while i < len(word):
            if word[i] not in cur.chars:
                cur.chars[word[i]] = TrieNode()
            cur = cur.chars[word[i]]
            i+=1
        cur.isEnd = True

    def search(self, word: str) -> bool:
        cur = self.Trie
        for c in word:
            if c not in cur.chars:
                return False
            cur = cur.chars[c]
        return cur.isEnd

    def startsWith(self, prefix: str) -> bool:
        cur = self.Trie
 
        for c in prefix:
            if c not in cur.chars:
                return False
            cur = cur.chars[c]
        
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
