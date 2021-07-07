class Trie:
    """
        https://leetcode.com/problems/implement-trie-prefix-tree/
    """
    """
        // Time Complexity : O(n) -> Search, Insert, Startswith
                'n' is the length of the string
        // Space Complexity : O(n)
    """

    class Node:
        def __init__(self):
            self.children = {}
            self.value = None
            self.is_end = False

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = self.Node()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur = self.root
        for c in word:
            if c not in cur.children:
                cur.children[c] = self.Node()
            cur = cur.children[c]
        cur.is_end = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        cur = self.root
        for c in word:
            if c in cur.children:
                cur = cur.children[c]
            else:
                return False
        return cur.is_end

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        cur = self.root
        for c in prefix:
            if c in cur.children:
                cur = cur.children[c]
            else:
                return False
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
