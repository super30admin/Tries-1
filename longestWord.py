"""
Time Complexity : insert() - O(n)   
                  longestWord() - O(n)
Space Complexity : insert() - O(n)   
                  longestWord() - O(1) [O(l) - stack space where l is the length of the longest word]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""

class Solution:   
    class TrieNode:
        def __init__(self):
            self.children = [None] * 26
            self.word = None
    
    def __init__(self):
        self.root = self.TrieNode()
        
    def insert(self, words):
        for word in words:
            curr = self.root
            for i in range(len(word)):
                idx = ord(word[i]) - ord('a')
                if not curr.children[idx]:
                    curr.children[idx] = self.TrieNode()
                curr = curr.children[idx]
                if i == len(word) - 1:
                    curr.word = word
                    
    def longestWord(self, words):
        self.insert(words)
        curr = self.root
        return self.dfs(curr.children, "")
                
    def dfs(self, curr_children_list, output):
        for i in range(len(curr_children_list)-1, -1, -1):
            if curr_children_list[i] and curr_children_list[i].word:
                output = self.dfs(curr_children_list[i].children, output)
            if curr_children_list[i] and curr_children_list[i].word and len(curr_children_list[i].word) >= len(output):
                output = curr_children_list[i].word
                
        return output
        
s = Solution()
print(s.longestWord(["w","wo","wor","worl","world"]))
print(s.longestWord(["a","banana","app","appl","ap","apply","apple"]))
    