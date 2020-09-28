# Time Complexity : O(n)
# Space Complexity : O(n) n = no. chars in Trie
# Did this code successfully run on Leetcode : No (Getting empty value)
# Any problem you faced while coding this : No

class Solution(object):
    
    class TrieNode():
        def __init__(self):
            self.children = {}
            self.word = ''
    
    def __init__(self):
        self.root = self.TrieNode()
        self.res = ''
        
    def insert(self, word):
        curr = self.root
        for c in word:
            if c not in curr.children:
                curr.children[c] = self.TrieNode()
            curr = curr.children[c]
        
        curr.word = word
    
    def dfs(self, root):
        if len(root.word) > len(self.res):
            self.res = root.word
        
        for i in range(len(root.children)):
            if root.children[i] is not None:
                self.dfs(root.children[i])
        
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        if len(words) == 0:
            return
        
        root = self.TrieNode()
        for word in words:
            self.insert(word)
        
        self.dfs(root)
        return self.res
