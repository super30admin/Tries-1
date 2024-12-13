# Approach:
# A Trie (prefix tree) is implemented using a nested dictionary structure, where each node represents a character.
# The root node is an empty dictionary, and each key in the dictionary represents a child node for a character.
# To mark the end of a word, we use a special flag (e.g., a key `isEnd` set to True).
# This allows efficient insertion, search, and prefix matching by traversing the tree.

# Time Complexity:
# - insert: O(n), where n is the length of the word.
# - search: O(n), where n is the length of the word.
# - startsWith: O(m), where m is the length of the prefix.
# Space Complexity: O(n * k), where n is the number of words inserted and k is the average length of the words.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Trie:

    def __init__(self):
        # Initialize the root of the Trie as an empty dictionary
        self.root = {}
    
    def insert(self, word: str) -> None:
        # Start at the root node
        node = self.root
        for char in word:
            # If the character is not already a child, create a new node
            if char not in node:
                node[char] = {}
            # Move to the child node
            node = node[char]
        # Mark the end of the word
        node['isEnd'] = True
    
    def search(self, word: str) -> bool:
        # Start at the root node
        node = self.root
        for char in word:
            # If the character is not in the current node, the word is not found
            if char not in node:
                return False
            # Move to the child node
            node = node[char]
        # Check if the current node marks the end of a word
        return 'isEnd' in node
    
    def startsWith(self, prefix: str) -> bool:
        # Start at the root node
        node = self.root
        for char in prefix:
            # If the character is not in the current node, the prefix is not found
            if char not in node:
                return False
            # Move to the child node
            node = node[char]
        # If we've successfully traversed the prefix, return True
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
