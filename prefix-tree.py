# This Trie implementation supports insertion, word search, and prefix search.

# insert adds a word to the Trie by creating child nodes as needed.
# search checks if a word exists in the Trie, returning True if it ends at a valid word node.
# startsWith verifies if a prefix exists in the Trie.

# Uses an array of size 26 for child nodes, representing each lowercase letter.
# Efficient for operations involving multiple lookups or prefix checks.

# TC: O(m) - m is the length of the word or prefix for insert, search, and startsWith.
# SC: O(n * m) - Space for the Trie where n is the number of words and m is the average word length.


class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.endOfWord = False

class Trie:  # Renamed from PrefixTree to Trie
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        cur = self.root
        for c in word:
            i = ord(c) - ord("a")
            if cur.children[i] is None:
                cur.children[i] = TrieNode()
            cur = cur.children[i]
        cur.endOfWord = True

    def search(self, word: str) -> bool:
        cur = self.root
        for c in word:
            i = ord(c) - ord("a")
            if cur.children[i] is None:
                return False
            cur = cur.children[i]
        return cur.endOfWord

    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        for c in prefix:
            i = ord(c) - ord("a")
            if cur.children[i] is None:
                return False
            cur = cur.children[i]
        return True
