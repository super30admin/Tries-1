from typing import List
from collections import deque


class Solution:
    """
        https://leetcode.com/problems/longest-word-in-dictionary/
    """
    """
        // Time Complexity : O(n * w) 
            'n' is the number of words, 'w' is the avg len of the word 
        // Space Complexity : O(w) 
             'w' is the no of unique characters in all words in dic
    """

    class Node:
        def __init__(self):
            self.children = [None] * 26
            self.word = None

    def __init__(self):
        self.root = self.Node()

    def insert(self, word):
        cur = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if cur.children[idx] is None:
                cur.children[idx] = self.Node()
            cur = cur.children[idx]
        cur.word = word

    def longestWord(self, words: List[str]) -> str:
        # insert the words
        for word in words:
            self.insert(word)

        # level order traversal
        queue = deque()
        queue.append(self.root)
        word = ""
        while queue:
            cur = queue.popleft()
            word = cur.word
            for i in reversed(range(26)):
                if cur.children[i] and cur.children[i].word is not None:
                    queue.append(cur.children[i])
        return word
