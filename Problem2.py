"""
TC: O(S) {where S is the total number of characters across all words in the input. This includes O(S) for insertion and O(S) in the worst case for the DFS traversal of the Trie.}
SC: O(S) {The space is determined by the total number of nodes in the Trie, which is at most the sum of the lengths of all words.}

Approach:

This problem is solved using a **Trie** data structure combined with a **Depth-First Search (DFS)** traversal. The goal is to find the longest word that can be built one character at a time from other words in the list.

1.  **Trie Construction**: First, all words in the input list are **inserted** into the Trie. A standard `TrieNode` is used, where the `isEnd` flag is critical, as it signifies a complete, valid word from the dictionary.
2.  **DFS Traversal**: After insertion, a recursive `dfs` function is called starting from the root of the Trie. This function explores paths in the Trie under one strict condition: it can only move to a child node if that child node represents the **end of a valid word** (i.e., `child.isEnd` is `True`). This condition ensures that the path being built is a word constructed one character at a time from shorter existing words.
3.  **Path Tracking and Update**: The `dfs` function maintains the current word being built (`path`). In the base case (before recursion), the length of the current path is compared against the length of the globally stored `self.result`. If the current path is longer, it becomes the new `self.result`. The **lexicographically smallest** tie-breaker is implicitly handled: since the `dfs` loop iterates through children in alphabetical order (a-z), a longer word will always be preferred, and if lengths are equal, the one found earliest (alphabetically) will be retained. The algorithm uses a form of **backtracking** by passing a copy of the path's length to properly reset it after the recursive call.

The problem ran successfully on LeetCode.
"""
from typing import List
class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None]*26
            self.isEnd = False
    
    def __init__(self):
        self.root = self.TrieNode()
        self.result = ""
    
    def insert(self, word: str) -> None:
        curr = self.root

        for ch in word:

            if not curr.children[ord(ch) - ord('a')]:
                curr.children[ord(ch) - ord('a')] = self.TrieNode()

            curr = curr.children[ord(ch) - ord('a')]
        curr.isEnd = True

    def dfs(self, curr, path):
        if len(self.result) < len(path):
            self.result = "".join(path)

        for i in range(26):
            if curr.children[i] is not None and curr.children[i].isEnd:

                le = len(path)

                # action
                path.append(chr(i + ord('a')))

                # recurse
                self.dfs(curr.children[i], path)

                # backtrack
                path = path[:le]

    def longestWord(self, words: List[str]) -> str:
        
    
        for word in words:
            self.insert(word)
        
        self.dfs(self.root, [])
        return self.result
