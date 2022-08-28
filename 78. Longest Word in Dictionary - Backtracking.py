# Backtracking Solution
class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False
        self.c = ""


class Solution:
    def insert(self, word):
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            if not curr.children[ord(ch) - ord("a")]:
                curr.children[ord(ch) - ord("a")] = TrieNode()
            curr = curr.children[ord(ch) - ord("a")]
            # print(ch)
        curr.isEnd = True
        curr.c = ch
        # print(curr.word)

    result = None

    def longestWord(self, words: List[str]) -> str:
        self.root = TrieNode()
        self.result = []

        for word in words:
            # print(word)
            self.insert(word)

        self.dfs(self.root, path=[])
        return "".join(self.result)

    def dfs(self, curr, path):
        if len(path) >= len(self.result):
            self.result = path.copy()

        for i in range(25, -1, -1):
            if curr.children[i] != None and curr.children[i].isEnd:
                # print(curr.children[i])
                # ch = curr.children[i].c
                path.append(curr.children[i].c)  # action
                # print(path)
                self.dfs(curr.children[i], path)  # recurse
                path.pop(-1)  # Backtracking

# TC =O(nk).
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
