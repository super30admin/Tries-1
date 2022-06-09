# Time Complexity: O(NK) for building a trie with N words, each word of average length K
# Space Complexity: O(NK) in worst case, if we have to store all N words of length K on average
# Did this run successfully on Leetcode: Yes
# Any problems faced while coding: Took a few tries to get the correct Python code

from collections import deque
class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.word = None
        
class Solution:

    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c) - ord(a)] is None:
                curr.children[ord(c) - ord('a')] = TrieNode()
            curr = curr.children[ord(c) - ord('a')]
        curr.word = word

    def longestWord(self, words):

        root = self.root
        for word in words:
            self.insert(word)
        q = deque()
        q.append(root)
        curr = TrieNode()
        while len(q) != 0:
            curr = q.popleft()
            for i in range(25, -1, -1):
                if curr.children[i] is not None and curr.children[i].word is not None: 
                    q.append(curr.children[i])
        if curr.word is None:
            return ""
        return curr.word        
        