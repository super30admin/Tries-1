# Time Complexity : O(nl) where n is the number of words and l is the average length of the words
# Space Complexity : O(nl)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


from collections import deque


class TrieNode(object):
    def __init__(self):
        self.word = None
        self.children = [None] * 26


class Solution(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for i in word:
            temp = ord(i) - ord('a')
            if curr.children[temp] == None:
                curr.children[temp] = TrieNode()
            curr = curr.children[temp]
        curr.word = word

    def longestWord(self, words):
        for i in words:
            self.insert(i)

        q = deque()
        q.appendleft(self.root)
        curr = None

        while len(q) != 0:
            curr = q.pop()
            for j in range(25, -1, -1):
                level = curr.children[j]
                if level != None and level.word != None:
                    q.appendleft(level)
        return curr.word
