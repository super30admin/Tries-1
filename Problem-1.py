# 208. Implement Trie (Prefix Tree)

'''
Leetcode all test cases passed: Yes
Solution:
    n is length of word
    def insert(self, word: str)
        Time Complexity: O(n) 
        Space Complexity: O(1)
    def search(self, word: str)
        Time Complexity: O(n) 
        Space Complexity: O(1)
    def startsWith(self, word: str)
        Time Complexity: O(n) 
        Space Complexity: O(1)

'''
from collections import defaultdict
class Trie:

    def __init__(self):
        self.children = defaultdict(Trie)
        self.end = False

    def insert(self, word: str) -> None:
        curr = self
        for ch in word:
            curr = curr.children[ch]
        curr.end = True
        
    def search(self, word: str) -> bool:
        curr = self
        for ch in word:
            if ch in curr.children:
                curr = curr.children[ch]
            else:
                return False
        return curr.end

    def startsWith(self, prefix: str) -> bool:
        curr = self
        for ch in prefix:
            if ch in curr.children:
                curr = curr.children[ch]
            else:
                return False

        return True
