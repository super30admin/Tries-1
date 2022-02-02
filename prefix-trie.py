# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Node:
    def __init__(self, val):
        self.val = val
        self.child = {}

        # for prefix searches only
        self.last = False


class Trie:

    def __init__(self):
        self.root = Node(None)

    def insert(self, word: str) -> None:  # O(n) space and time
        root = self.root

        for ch in word:
            if ch not in root.child:
                root.child[ch] = Node(ch)
            root = root.child[ch]
        root.last = True

    def search(self, word: str) -> bool:  # O(n) time and O(1) space
        root = self.root

        for ch in word:
            if ch not in root.child:
                return False
            root = root.child[ch]
        return root.last

    def startsWith(self, prefix: str) -> bool:  # O(n) time and O(1) space
        root = self.root

        for ch in prefix:
            if ch not in root.child:
                return False
            root = root.child[ch]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
