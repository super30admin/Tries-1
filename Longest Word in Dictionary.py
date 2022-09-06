# Time Complexity: O(n * k) n is no. of words and k is max length of a word
# Space Complexity:O(n * 26 ^ k) n is no. of words and k is max length of a word

class Solution:
    class TrieNode:
        def __init__(self):
            self.isEnd = False
            self.children = [None for _ in range(26)]
    
    def __init__(self):
        self.root = self.TrieNode()
        self.result = []
    
    def insert(self,word):
        curr = self.root
        
        for i in range(len(word)):
            char = word[i]
            if curr.children[ord(char)-ord('a')] is None:
                curr.children[ord(char)-ord('a')] = self.TrieNode()
            curr = curr.children[ord(char)-ord('a')]
        
        curr.isEnd = True
    
    def bactrack(self,node,curr):
        # Base
        if len(curr)>len(self.result):
            self.result = list(curr)
        # Logic
        for i in range(26):
            child = node.children[i]
            if child and child.isEnd:
                # Action
                curr.append(chr(ord('a')+i))
                # Recurse
                self.bactrack(child,curr)
                # Backtrack
                curr.pop()
    
            
    def longestWord(self, words: List[str]) -> str:
        # self.root = TrieNode() Already called in constructor
        
        for word in words: # O(n*k) time where n = no.of words and k is avg len of words
            self.insert(word)
        
        self.bactrack(self.root,[])
        
        return "".join(self.result)
        
        
        