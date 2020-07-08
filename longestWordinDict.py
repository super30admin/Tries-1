from collections import deque
class TrieNode(object):
    def __init__(self):
        self.word = None
        self.branches = [None] * 26


class Solution(object):
    # Time Complexity : O(nl) where n is the number of words and l is the average length of the words
    # Space Complexity : O(nl), where n is the number of words in the trie and l is the average length of the words
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    # Your code here along with comments explaining your approach

    # The given words are first inserted in the trie, then searched.
    # A BFS is performed to search all nodes level by level while also maintaining
    # smaller lexicographical order, In the end the longest word is returned.
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for i in word:
            temp = ord(i) - ord('a')
            if curr.branches[temp] == None:
                curr.branches[temp] = TrieNode()
            curr = curr.branches[temp]
        curr.word = word

    def longestWord(self, words):
        # adding to the trie
        for i in words:
            self.insert(i)
        # queue init
        q = deque()
        q.appendleft(self.root)
        curr = None
        # BFS with small lexicographical order
        while len(q) != 0:
            curr = q.pop()
            for j in range(25, -1, -1):
                level = curr.branches[j]
                if level != None and level.word != None:
                    q.appendleft(level)
        return curr.word
