# Time Complexity : O(D) where D is size of dictionary
# Space Complexity : O(D) where D is size of dictionary
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I store all the words in trie and interate from the right side of the trie and move to left using BFS style
# iteration. At the end I will have the longest word

from collections import deque

class TrieNode():
    def __init__(self):
        self.children = [None for x in range(26)]
        self.word = None

class Trie():

    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word):
        current = self.root
        for l in word:
            index = ord(l) - ord("a")
            if not current.children[index]:
                current.children[index] = TrieNode()
            current = current.children[index]
        current.word = word

class Solution:
    def longestWord(self, words: List[str]) -> str:
        t = Trie()
        
        result = None
        for word in words:
            t.insert(word)
            
        q = deque()
        current = t.root
        for child in reversed(current.children):
            if child and child.word:
                result = child.word
                q.append(child)
            
        while len(q):
            size = len(q)
            for i in range(size-1, -1, -1):
                temp = q.popleft()
                for child in reversed(temp.children):
                    if child and child.word:
                        result = child.word
                        q.append(child)
                        
        return result
                    
                