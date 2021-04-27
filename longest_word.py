# Time Complexity: O(mn) where m is the number of words and n is the average length of word
# Space Complexity: O(mn) where m is the number of words and n is the average length of word
# Ran on Leetcode: Yes

from queue import Queue

class TrieNode:
    def __init__(self):
        self.word = None
        self.children = [None] * 26
                
class Solution:
    def longestWord(self, words: List[str]) -> str:
        if not len(words):
            return ""
        self.root = TrieNode()
        for word in words:
            self.insert(word)
        curr = self.root
        q = Queue()
        q.put(curr)
        while not q.empty():
            curr = q.get()
            for i in range(25, -1, -1):
                if curr.children[i] and curr.children[i].word:
                    q.put(curr.children[i])
        return curr.word
            
    
    def insert(self, word):
        curr = self.root
        for letter in word:
            if not curr.children[ord(letter) - 97]:
                curr.children[ord(letter) - 97] = TrieNode()
            curr = curr.children[ord(letter) - 97]
        curr.word = word
        
    
        