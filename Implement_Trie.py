'''
Time Complexity : O(n) time for insert and search
Space Complexity - O(n*26^k)
'''


class Trie:

    def __init__(self):
        self.children = defaultdict(Trie)
        self.isEnd = False

    def insert(self, word: str) -> None:
        curr = self
        for c in word:
            curr = curr.children[c]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        curr = self
        for c in word:
            if c in curr.children:
                curr = curr.children[c]
            else:
                return False
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self
        for c in prefix:
            if c in curr.children:
                curr = curr.children[c]
            else:
                return False
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
