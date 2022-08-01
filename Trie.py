# Did this code successfully run on Leetcode : Yes
class TrieNode:
    def __init__(self):
        self.children = {}
        self.endOfWord = False

class Trie:
    # O(1) time and space
    def __init__(self):
        self.root = TrieNode()

    # O(w) time and space where w is the length of the word
    def insert(self, word: str) -> None:
        cur = self.root
        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
        cur.endOfWord = True

    # O(w) time where w is the length of the word
    # O(1) space complexity
    def search(self, word: str) -> bool:
        cur = self.root

        for c in word:
            if c not in cur.children:
                return False
            cur = cur.children[c]
        return cur.endOfWord

    # O(p) time where p is the length of the prefix
    # O(1) space
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
