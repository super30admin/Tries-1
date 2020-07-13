# Time Complexity : Add - O(mn) - m=no. of words, n = avg length of a word
# Space Complexity :O(n) - avf length of a word
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. create TrieNode DS with insert operation. Also create a new TrieNode that stores the net string upto that node
2. Perform a BFS starting from root and given preference to high lexicographical letter. To push on to stack if isend corresponding to that is True because we need a word that can be formed on letter at a time
3. the last root to be popped would be the longest word built with one charachter and lexicographically smaller
'''

from collections import deque
class TrieNode():
    
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False
        self.string = ""
        
    
class Solution:
    
    def __init__(self):
        
        self.root = TrieNode()

    def _insert(self, word):
        
        current = self.root
        temp = []
        for letter in word:
            if current.children[ord(letter)-ord('a')] is None:
                current.children[ord(letter)-ord('a')] = TrieNode()
                
            temp.append(letter)
            current.children[ord(letter)-ord('a')].string = "".join(temp)
            current = current.children[ord(letter)-ord('a')]
        
        current.isEnd = True
        
        print (current.string)
        
                
    def longestWord(self, words: List[str]) -> str:
        
        if not words or len(words) < 1:
            return ""
        
        for word in words:
            self._insert(word)
            
        queue = deque()
        queue.append(self.root)
        
        while queue:
            root = queue.popleft()
            
            for i in range(25,-1,-1):
                if root.children[i] is not None and root.children[i].isEnd:
                    queue.append(root.children[i])
                    
        print (root.string)
        return root.string
                    
   
                    
                    
        
        