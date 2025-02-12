class TreeNode:
    def __init__(self):
        self.children = {}
        self.endOfWord = False


class Trie:

    def __init__(self):
        self.root = TreeNode()

    # T: O(n), S: O(n) where n = length of the chars in word (max 26)
    def insert(self, word: str) -> None:
        cur = self.root

        for c in word:
            if c not in cur.children:
                cur.children[c] = TreeNode()
            cur = cur.children[c]
        cur.endOfWord = True

    # T: O(n), S: O(1)
    def search(self, word: str) -> bool:
        cur = self.root

        for c in word:
            if c not in cur.children:
                return False
            cur = cur.children[c]
        return cur.endOfWord

    # T: O(n), S: O(1)
    def startsWith(self, prefix: str) -> bool:
        cur = self.root

        for c in prefix:
            if c not in cur.children:
                return False
            cur = cur.children[c]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
