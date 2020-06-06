# Time complexity: O(N) where is N is the length of the word
# Space complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TrieNode:

    def __init__(self):
        self.isword = False
        self.char = {}


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.node = TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.

        """
        current = self.node
        for i in word:
            if i not in current.char:
                current.char[i] = TrieNode()
            current = current.char[i]
        if current.isword is False:
            current.isword = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        current = self.node
        for i in word:
            if i not in current.char:
                return False
            current = current.char[i]
        return current.isword

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        current = self.node
        for i in prefix:
            if i not in current.char:
                return False
            current = current.char[i]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
