# Time: O(n)
# Space Complexity: O(n)
class Trie:

    def __init__(self):
        self.children = {}

    def insert(self, word: str) -> None: # Time: O(n)
        current = self.children
        for w in word:
            if w not in current:
                current[w] = {}
            current = current[w]
        current['#'] = True

    def search(self, word: str) -> bool: # Time: O(n)
        current = self.children
        for w in word:
            if w not in current:
                return False
            current = current[w]
        return '#' in current

    def startsWith(self, prefix: str) -> bool: # Time: O(n)
        current = self.children
        for w in prefix:
            if w not in current:
                return False
            current = current[w]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)