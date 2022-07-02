# Time Complexity : 
#      For Insertion: O(k*N) where k is averange length of the given words and N is number of words given
#      For Finding Longest Word: O(k) where k is length of the longest word
# Space Complexity : O(k * N) where k is averange length of the word and N is number of words given
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from collections import deque

class TrieNode():
    def __init__(self):
        self.children = [None for _ in range(26)]
        self.isEnd = False
        self.word = ""

class Solution:
    def __init__(self):
        self.root = TrieNode()
    
    def longestWord(self, words: List[str]) -> str:
        q = deque()
        for word in words:
            self.insertWord(word)
        
        curr = self.root
        q.appendleft(curr)
        while len(q) > 0:
            tnode = q.pop()
            for i in range(25, -1, -1):
                if tnode.children[i] != None and tnode.children[i].isEnd:
                    q.appendleft(tnode.children[i])
        
        return tnode.word
            
        
        
    def insertWord(self, word):
        curr = self.root
        for l in word:
            if curr.children[ord(l) - ord('a')] == None:
                curr.children[ord(l) - ord('a')] = TrieNode()
            curr = curr.children[ord(l) - ord('a')]
            
        curr.isEnd = True
        curr.word = word
        