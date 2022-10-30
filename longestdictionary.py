'''
Time Complexity: O(M*L)
Space Complexity: O(M*L)
'''
from collections import deque
class TrieNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.word = None
        
class Solution:
    def __init__(self):
        self.root = TrieNode()
        
    def insertNode(self, words):
        for i in words:
            dummy = self.root
            for j in i:
                childVal = ord(j) - ord('a')
                if(not dummy.children[childVal]):
                    dummy.children[childVal] = TrieNode()
                dummy = dummy.children[childVal]
            dummy.word = i
        
    def longestWord(self, words: List[str]) -> str:
        if(len(words)==0): return ""
        self.insertNode(words)
        q = deque([])
        dummy = self.root
        q.append(dummy)
        while(len(q)>0):
            val = q.popleft()
            for i in range(25, -1, -1):
                if(val.children[i] and val.children[i].word):
                    q.append(val.children[i])
        if(not val.word): return ""
        return val.word
        
        