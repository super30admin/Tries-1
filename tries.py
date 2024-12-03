class Trie:

    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

    def insert(self, word: str) -> None:
        root = self
        curr = root
        for c in word:
            if not curr.children[ord(c)-ord('a')]:
                curr.children[ord(c)-ord('a')] = Trie()
            curr = curr.children[ord(c)-ord('a')]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        curr = self
        for c in word:
            if not curr.children[ord(c)-ord('a')]:
                return False
            curr = curr.children[ord(c)-ord('a')]
        
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self
        for c in prefix:
            if not curr.children[ord(c)-ord('a')]:
                return False
            curr = curr.children[ord(c)-ord('a')]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
