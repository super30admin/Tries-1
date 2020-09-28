# Time Complexity : O(n)
# Space Complexity : O(m), m is the number of characters in TrieNode
# Did this code successfully run on Leetcode : No, getting error
# Any problem you faced while coding this : Yes, not passing on leetcode. Please let me know where I went wrong in the logic.

# Your code here along with comments explaining your approach

class Solution:
    
    class TrieNode():
        def __init__(self):
            self.children = [None for _ in range(26)]
            self.word = ''
    
    def __init__(self):
        self.root = self.TrieNode()
        self.result = ''
        
    def insert(self, word):
        
        curr = self.root
        
        for x in word:
            if x not in curr.children:
                curr.children[x] = self.TrieNode()
            curr = curr.children[x]
                
        curr.word = word
                
    def dfs(self, root):
        
        if len(root.word) > len(self.result):
            self.result = root.word
            
        for i in range(26):
            if root.children[i] is not None:
                self.dfs(root.children[i])
    
    def longestWord(self, words: List[str]) -> str:
        
        if words == None or len(words) == 0:
            return ""
        
        for word in words:
            self.insert(word)
        
        self.dfs(self.root)
        
        return self.result
        
            