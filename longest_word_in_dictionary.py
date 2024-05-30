# Time Complexity : O(nl)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26

class Solution:
    def __init__(self):
        self.root = TrieNode()
        self.ans = ""

    def insert(self, word):
        curr = self.root
        for char in word:
            index = ord(char) - ord('a')
            if curr.children[index] is None:
                curr.children[index] = TrieNode()
            curr = curr.children[index]
        curr.isEnd = True

    def longestWord(self, words):
        for word in words:
            self.insert(word)
        self.backtrack(self.root, "")
        return self.ans

    def backtrack(self, curr, path):
        if len(path) > len(self.ans):
            self.ans = path

        for i in range(26):
            if curr.children[i] is not None and curr.children[i].isEnd:
                le = len(path)
                path = path + chr(i + ord('a'))
                self.backtrack(curr.children[i], path)
                path = path[0:le]