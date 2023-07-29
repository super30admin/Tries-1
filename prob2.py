# Time Complexity :  O(1)
# Space Complexity :O(n)
# Passed on Leetcode: yes

import queue

class TrieNode():
    def __init__(self):
        self.flag = False
        self.arr = [None for _ in range(26)]

class Trie():
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        node = self.root
        for char in word:
            idx = ord(char) - ord('a')
            if node.arr[idx] == None:
                node.arr[idx] = TrieNode()
            node = node.arr[idx]
        node.flag = True

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for val in words:
            trie.insert(val)
        
        q = queue.Queue()
        s = queue.Queue()
        q.put(trie.root)
        s.put('')
        n = ''
        while not q.empty():
            node = q.get()
            st = s.get()
            for idx in range(25, -1, -1):
                child = node.arr[idx]
                if child != None and child.flag == True:
                    q.put(child)
                    n = st + chr(ord('a') + idx)
                    s.put(n)

        return n

