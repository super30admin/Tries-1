"""
    Student : Shahreen Shahjahan Psyche
              
    Pased Test Cases : Yes
    
"""

class Node:
    def __init__(self):
        self.isEnd = False
        self.records = [None for i in range(26)]
        self.word = ""

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.head = Node()
        
        
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        current = self.head
        for i in range(len(word)):
            pos = ord(word[i]) - ord("a")
            if current.records[pos]:
                current = current.records[pos]
            else:
                newNode = Node()
                current.records[pos] = newNode
                current = current.records[pos]
        current.isEnd = True
        current.word = word
        
    def get_trie(self):
        return self.head

class Solution:
    def longestWord(self, words: List[str]) -> str:
        
        if not words:
            return ""
        
        trie_dict = Trie()
        res = ""
        max_len = 0
        
        
        for i in words:
            trie_dict.insert(i)
            
        trie = trie_dict.get_trie()
        
        from collections import deque
        
        # bfs
        track = deque()
        for i in range(26):
            if trie.records[i] is not None:
                track.append(trie.records[i])
        
        while track:
            root = track.popleft()
            if root.isEnd == True:
                if len(root.word) > max_len:
                    max_len = len(root.word)
                    res = root.word
                for i in range(26):
                    if root.records[i] is not None:
                        track.append(root.records[i])
        return res
                        
        
        
        
        
