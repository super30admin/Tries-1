# Time Complexity :
# - insert: O(n), where n is the length of the word
# - search: O(n), where n is the length of the word
# - startsWith: O(n), where n is the length of the prefix
# Space Complexity : O(n * m), where n is the number of words inserted, and m is their average length
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I implemented a Trie using a TrieNode class to store children and an end-of-word flag.
# For insert, I created nodes along the path if they didn’t exist and marked the end node.
# For search, I traversed down the trie and returned True only if the path existed and ended with a word.
# For startsWith, I returned True as long as the prefix path was valid.

class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end = False

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.is_end = True

    def search(self, word: str) -> bool:
        node = self.root
        for char in word:
            if char not in node.children:
                return False
            node = node.children[char]
        return node.is_end

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for char in prefix:
            if char not in node.children:
                return False
            node = node.children[char]
        return True
