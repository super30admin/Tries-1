class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.childern = [None] * 26


class Trie:

    def __init__(self):
        self.root = TrieNode()

    # Time Complexity : O(len(Word))
    # Space Complexity : O(len(Word))
    def insert(self, word: str) -> None:
        curr = self.root
        for char in word:
            key = ord(char) - ord('a')
            if not curr.childern[key]:
                curr.childern[key] = TrieNode()
            curr = curr.childern[key]
        curr.isEnd = True
        return

    # Time Complexity : O(len(Word))
    # Space Complexity : O(1)
    def search(self, word: str) -> bool:
        curr = self.root
        for char in word:
            key = ord(char) - ord('a')
            if not curr.childern[key]:
                return False
            curr = curr.childern[key]
        return curr.isEnd == True

    # Time Complexity : O(len(prefix))
    # Space Complexity : O(1)
    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for char in prefix:
            key = ord(char) - ord('a')
            if not curr.childern[key]:
                return False
            curr = curr.childern[key]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)