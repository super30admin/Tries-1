"""
# Tries-1

## Problem1
Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.


"""


class TrieNode():
    def __int__(self):
        self.isWord = False
        self.children = [None] * 26


class Trie():
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
        for char in word:
            print(node)
            print(ord(char) - ord('a'))
            if node.children[ord(char) - ord('a')] == None:
                node.children[ord(char) - ord('a')] = char

            node = node.children[ord(char) - ord('a')]

        node.isWord = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root
        for char in word:
            if node.children[ord(char) - ord('a')] == None:
                return False
            node = node.children[ord(char) - ord('a')]
        return node.isWord

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        for char in prefix:
            if node.children[ord(char) - ord('a')] == None:
                return False
            node = node.children[ord(char) - ord('a')]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)