from collections import deque


class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.word = None


class Solution:
    def insert(self, word):
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            if not curr.children[ord(ch) - ord("a")]:
                curr.children[ord(ch) - ord("a")] = TrieNode()
            curr = curr.children[ord(ch) - ord("a")]
        curr.word = word
        # print(curr.word)

    result = None

    def longestWord(self, words: List[str]) -> str:
        self.root = TrieNode()
        self.result = ""

        for word in words:
            # print(word)
            self.insert(word)

        self.dfs(self.root)
        return self.result

    def dfs(self, curr):
        if curr.word != None and len(curr.word) >= len(self.result):
            self.result = curr.word
            # print(self.result)

        for i in range(25, -1, -1):
            if curr.children[i] != None and curr.children[i].word is not None:
                self.dfs(curr.children[i])
# TC =O(nk).
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
