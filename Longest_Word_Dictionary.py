'''
Time Complexity - O(n*L)
Space Complexity - O(n*L)
'''


class TrieNode():
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isEnd = False


class Solution:
    def longestWord(self, words: List[str]) -> str:
        self.root = TrieNode()
        self.result = ""
        for i in words:
            self.insert(i)
        self.dfs(self.root, "")
        return self.result

    def insert(self, word):
        curr = self.root
        for char in word:
            if curr.children[ord(char) - ord('a')] == None:
                curr.children[ord(char) - ord('a')] = TrieNode()
            curr = curr.children[ord(char) - ord('a')]
        curr.isEnd = True

    def dfs(self, root, string):
        if len(string) > len(self.result):
            self.result = string
        for i in range(26):
            child = root.children[i]
            if child and child.isEnd:
                string += chr(ord('a')+i)
                self.dfs(child, string)
                string = string[:-1]
