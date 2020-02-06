"""
Time complexity: O(m*n)
Space Complexity: O(m*n) (Worst case)
Compiled on Leetcode: Yes
Difficulties faced: No
"""
from collections import deque

class Trie:
        def __init__(self, children, word):
            self.children = children
            self.word = word
            
class Solution:
    def __init__(self):
        self.root = Trie([None for i in range(26)], None)
        
        
    def insertIntoTrie(self, word):
        current  = self.root
        for i in range(len(word)):
            wordIndex = ord(word[i]) - ord('a')
            if current.children[wordIndex] is None:
                current.children[wordIndex] = Trie([None for i in range(26)], None)
            if i == len(word) - 1:
                current.children[wordIndex].word = word
            else:
                current = current.children[wordIndex]
            
            
        
    def longestWord(self, words: List[str]) -> str:
        for word in words:
            self.insertIntoTrie(word)
        
        # BFS
        queue = deque()
        curr = self.root
        print(curr.word)
        queue.append(curr)
        result = ""
        while queue:
            current = queue.popleft()
            result = current.word
            for i in range(25,-1,-1):
                if current.children[i] is not None and current.children[i].word is not None:
                    queue.append(current.children[i])
        return result            
                    
                
        
        
        