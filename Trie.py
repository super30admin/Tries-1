class Trie:

    def __init__(self):
        self.root = {}

    def insert(self, word: str) -> None:
        curr =self.root
        for c in word:
            if c not in curr:
                curr[c] = {}
            curr = curr[c]
        curr['*']=''

    def search(self, word: str) -> bool:
        curr =self.root
        for c in word:
            if c not in curr:
                return False
            curr = curr[c]
        return '*' in curr

    def startsWith(self, prefix: str) -> bool:
        cur=self.root
        for c in prefix:
            if c not in cur:
                return False
            cur=cur[c]

        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)