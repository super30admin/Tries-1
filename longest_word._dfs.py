# Time Complexity : 
#      For Insertion: O(k*N) where k is averange length of the given words and N is number of words given
#      For Finding Longest Word: O(k) where k is length of the longest word
# Space Complexity : O(k * N) where k is averange length of the word and N is number of words given
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TrieNode():
    def __init__(self):
        self.children = [None for _ in range(26)]
        self.isEnd = False
        self.character = ""

class Solution:
    def __init__(self):
        self.root = TrieNode()
        self.result = []
    def longestWord(self, words: List[str]) -> str:
        for word in words:
            self.insertWord(word)
        
        curr = self.root
        self.dfs(curr, [])
        
        return "".join(self.result)
    
    def dfs(self, curr, currLongest):
        #base
        if len(self.result) < len(currLongest):
            self.result = currLongest[:]
        #logic
        for i in range(26):
            if curr.children[i] is not None and curr.children[i].isEnd == True:
                currLongest.append(curr.children[i].character)
                
                self.dfs(curr.children[i], currLongest)
                
                currLongest.pop()
                
            
        
        
    def insertWord(self, word):
        curr = self.root
        for l in word:
            if curr.children[ord(l) - ord('a')] == None:
                curr.children[ord(l) - ord('a')] = TrieNode()
            curr = curr.children[ord(l) - ord('a')]
            curr.character = l
            
        curr.isEnd = True
        