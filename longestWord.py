# Time Complexity : O(mn) m = number of words n = len(word)
# Space Complexity : O(MN) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


class TrieNode:
    def __init__(self):
        self.word = None
        self.children = [None for i in range(26)]
        
class Solution:
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word):
        curr = self.root 
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c) - ord('a')]  == None:
                curr.children[ord(c)- ord('a')] = TrieNode()
            curr = curr.children[ord(c) - ord('a')]
        curr.word = word
        
    def longestWord(self, words: List[str]) -> str:
        """
            USE BFS NOT DFS. Go from right to left bc lexicographical order
        """
        if not words:
            return ""
        
        for word in words:
            self.insert(word)
            
        q = deque([self.root])
        
        while q:
            curr = q.popleft()
            
            for i in range(25, -1, -1):
                if curr.children[i] != None and curr.children[i].word != None:
                    q.append(curr.children[i])
                    
        return curr.word