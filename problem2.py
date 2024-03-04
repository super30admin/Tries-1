# https://leetcode.com/problems/longest-word-in-dictionary/

# Time Complexity : O(Nlog(N)) where N is length of the input string.
# Space Complexity : O(N) is length of the input string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, Fixed it later.


# Your code here along with comments explaining your approach

# Approach : First we sort the input words. We then start adding every word to the trie. We keep a counter
# to track no of ends words in the given string. If it is equal to the string we then we update.
# Or else we don't update the result. At the end we return the result.
# FYI we can solve it using hashing as well.

from typing import List

class TrieNode:
    isEnd: bool
    children: []

    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26


class Trie:
    root: TrieNode
    result: str

    def __init__(self):
        self.root = TrieNode()
        self.result = ""

    def add(self, word):
        cur = self.root
        count = 1
        for char in word:
            index = ord(char) - 97
            if cur.children[index] is None:
                cur.children[index] = TrieNode()
            cur = cur.children[index]
            if cur.isEnd:
                count += 1
        cur.isEnd = True

        if count == len(word):
            # Update the result
            if len(word) > len(self.result):
                self.result = word
            elif len(word) == len(self.result):
                self.result = min(self.result, word)


class Solution:
    def longestWord(self, words: List[str]) -> str:
        mytrie = Trie()
        words.sort()
        for word in words:
            mytrie.add(word)

        return mytrie.result