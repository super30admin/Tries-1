"""
Time Complexity : O(n*k) where n is the no. of words and k is the average length
Space Complexity : O(n*k) where n is the no. of words and k is the average length
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
from collections import deque
class TrieNode:
    def __init__(self, char=""):
        self.char = char
        self.children = defaultdict(TrieNode)
        self.word = None
class Solution:
    def __init__(self):
        self.root = TrieNode()
        
    # Inserting the words in the Trie
    def insert(self, word):
        curr = self.root
        for char in word:
            if char not in curr.children:
                newNode = TrieNode(char)
                curr.children[char] = newNode
                curr = newNode
            else:
                curr = curr.children[char]
        curr.word = word
    def longestWord(self, words: List[str]) -> str:
        if len(words) == 0:
            return ""
        self.root = TrieNode()
        # Inserting all the words in the Trie
        for word in words:
            self.insert(word)
        # BFS
        q = deque([self.root])
        result = ""
        while q:
            curr = q.popleft()
            for c in curr.children.values():
                if c.word != None:
                    if len(c.word) > len(result) or len(c.word) == len(result) and c.word < result:
                        result = c.word
                    q.append(c)   
        return result
    
        
        