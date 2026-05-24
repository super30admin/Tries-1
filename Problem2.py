# Time Complexity --> O(n*l) where n is the number of words and l is the average length of a word
# Space Complexity --> O(n*l)
# Approach --> Insert all the words into a Trie and then do a BFS that checks if there is a next available node and is also end of a word. 
from collections import deque
class TrieNode():
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False

class Solution:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for char in word:
            index = ord(char)-ord('a')
            if curr.children[index] is None:
                curr.children[index] = TrieNode()
            curr = curr.children[index]
        curr.isEnd = True

    def longestWord(self, words: List[str]) -> str:
        for word in words:
            self.insert(word)
        
        q = deque()
        q.append(self.root)
        strs = deque()
        strs.append('')

        nodes = []
        while q:
            curr = q.popleft()
            currstr = strs.popleft()
            for i in range(25,-1,-1):
                if curr.children[i] is not None and curr.children[i].isEnd==True:
                    q.append(curr.children[i])
                    strs.append(currstr + chr(i+ord('a')))
        return currstr


