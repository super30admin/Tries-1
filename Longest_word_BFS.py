# Time complexity : O(n*l)
# Space complexity : O(n*l)
# Leetcode : Solved and submitted

from collections import deque
# define the TrieNode class and add a word at the end of each TrieNode
class TrieNode():
    def __init__(self):
        self.isEnd = False
        self.children = [None for _ in range(26)]
        self.word = ""
        
class Solution:
    # insert the words from dict into TrieNode
    def insert(self, word):
        count_till_now = 0
        curr = self.root
        for ch in word:
            if curr.children[ord(ch) - ord('a')] == None:
                curr.children[ord(ch) - ord('a')] = TrieNode()
            curr = curr.children[ord(ch) - ord('a')]
        curr.isEnd = True
        curr.word = word
        
    def longestWord(self, words: List[str]) -> str:
        self.root = TrieNode()
        # Insert the words into TrieNode
        for word in words:
            self.insert(word)
        
        # insert the root into queue
        q = deque([self.root])
        while q:
            # remove the root from the queue
            curr = q.popleft()
            # traverse from 25 till 0, so that we have the last word which is lexicographically correct
            for i in range(25,-1,-1):
              # check if the children of curr is not None and also that the isEnd flag is True
                if curr.children[i] != None and curr.children[i].isEnd:
                    # append those elements into the queue
                    q.append(curr.children[i])
        # at the end, we would just have one word remaining, return the complete word
        return curr.word
