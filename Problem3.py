"""
## Problem 3

Longest Word in Dictionary (https://leetcode.com/problems/longest-word-in-dictionary/)
"""

from typing import List

# ========================= Trie Node Definition =========================
class TrieNode:
    def __init__(self):
        self.child = [None] * 26  # For lowercase a-z
        self.isEnd = False        # Marks end of a valid word
        self.char = ""            # Stores character for path reconstruction

# ========================= Trie-Based DFS Solution =========================
class Solution:
    """
    Uses a Trie to insert all words and performs DFS to find the longest word
    such that all its prefixes also exist in the dictionary.
    
    Approach:
    - Build a Trie from all input words.
    - Perform DFS starting from the root, only following paths where each node
      marks the end of a valid word.
    - Track the longest valid word encountered.
    """

    # TC: O(N * L)
    # - N = number of words
    # - L = average word length (for insertion + DFS traversal)
    #
    # SC: O(N * L)
    # - Trie stores all characters in all words
    def __init__(self):
        self.root = TrieNode()
        self.output = ""

    def longestWord(self, words: List[str]) -> str:
        # Step 1: Insert all words into Trie
        for word in words:
            self.insertWord(word)

        # Step 2: DFS to find longest word with all prefixes present
        def dfs_helper(node, result):
            if len(result) > len(self.output) or (len(result) == len(self.output) and result < self.output):
                self.output = result

            for i in range(26):
                child = node.child[i]
                if child and child.isEnd:
                    dfs_helper(child, result + child.char)

        dfs_helper(self.root, "")
        return self.output

    def insertWord(self, word: str):
        curr_node = self.root
        for w in word:
            index = ord(w) - ord('a')
            if curr_node.child[index] is None:
                curr_node.child[index] = TrieNode()
                curr_node.child[index].char = w
            curr_node = curr_node.child[index]
        curr_node.isEnd = True
