'''
Time Complexity: O(N) where N is the total number of characters in the list of words
Space Complexity: O(N) where N is the total number of characters in the list of words
Run on leetcode: YES
'''
from typing import Optional


class TrieNode:
    def __init__(self, end=False):
        self.end = False
        self.children = [None] * 26
class Tries:
    def __init__(self):
        self.root = TrieNode()
    def insert(self, word: str) -> None:
        curr = self.root
        for ch in word:
            idx = ord(ch) - ord('a')
            if not curr.children[idx]:
                curr.children[idx] = TrieNode()
            curr = curr.children[idx]
        curr.end = True
class Solution:
    def backtrack(self, curr: Optional[TrieNode], path: str) -> None:
        #base
        if len(path) > len(self.maxStr):
            self.maxStr = path[:]
        #logic
        for i in range(26):
            if curr.children[i] != None and curr.children[i].end:
                path += chr(i + ord('a'))
                self.backtrack(curr.children[i], path)
                path = path[:-1]
    def longestWord(self, words: list[str]) -> str:
        self.maxStr = ""
        obj = Tries()
        for word in words:
            obj.insert(word)
        self.backtrack(obj.root, "")
        return self.maxStr