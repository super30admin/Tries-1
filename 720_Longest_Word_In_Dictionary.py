# Leetcode problem link : https://leetcode.com/problems/longest-word-in-dictionary/
# Time Complexity:    O(n)
# Space Complexity:   O(m) no of all the characters present in Trie
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
    1. Create a class with TrieNode with size 26 for all the lowercase characters. All the positions in thsi array will then contain a pointer to another TrieNode.
    2. Every word is stored as each character in next level of TrieNode list with root containing the first characters.
    3. For searching we start with root and looks for the character in each level. The boolean flag in each node signifies if the word ends at that point or not.
    4. Do a dfs at each node for every character and keep track of longest word
    
'''

class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None for _ in range(26)]
            self.word = ""
    
    def __init__(self):
        self.dictionary = self.TrieNode()
        self.result = ""

    def makeDictionary(self,words):
        for word in words:
            curr = self.dictionary
            for c in word:
                if curr.children[ord(c) - ord('a')] == None:
                    curr.children[ord(c) - ord('a')] = self.TrieNode()
                curr = curr.children[ord(c) - ord('a')]
            curr.word = word
    
    def dfs(self,root):
        if (len(root.word) > len(self.result)) or (len(root.word) == len(self.result) and root.word < self.result):
            self.result = root.word
        
        for i in range(0,26):
            if root.children[i] != None and root.children[i].word != '':
                self.dfs(root.children[i])
            
            
        
    def longestWord(self, words: List[str]) -> str:
        self.makeDictionary(words)
        
        curr = self.dictionary
        self.dfs(self.dictionary)
        return self.result

