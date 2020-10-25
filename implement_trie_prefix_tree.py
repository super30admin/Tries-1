"""
Problem: 208. Implement Trie (Prefix Tree)
Leetcode: https://leetcode.com/problems/implement-trie-prefix-tree/
For insert:
    Time Complexity: O(m), where m is the key length.
    Space Complexity: O(m)
For Search for a key in a trie:
    Time Complexity: O(m) In each step of the algorithm we search for the next key character. In the worst case the algorithm performs mm operations.
    Space Complexity: O(1)
For Search for a key prefix in a trie:
    Time Complexity: O(m), where m is the key length.
    Space Complexity: O(1)
Does this code run on Leetcode: Yes
"""


class TrieNode:
    def __init__(self):
        self.word = False
        self.children = {}


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.root
        for i in word:
            if i not in node.children:
                node.children[i] = TrieNode()
            node = node.children[i]
        node.word = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root

        for i in word:
            if i in node.children:
                node = node.children[i]
            else:
                return False
        return node.word

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root

        for i in prefix:
            if i in node.children:
                node = node.children[i]
            else:
                return False
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)