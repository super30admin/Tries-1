# Use Trie to store all the words
# Perform BFS to identify the longest word
# Time Complexity is O(mn)
# Space Complexity is O(mn), where n is the number of words and m is the average length of the word
from collections import deque
class Trie(object):
    def __init__(self):
        self.word = None
        self.children = [None]*26
    def insert(self,word):
        curr = self
        for c in word:
            index = ord(c) - ord('a')
            if(curr.children[index] == None):
                curr.children[index] = Trie()
            curr = curr.children[index]
        curr.word = word
            
class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        trie = Trie()
        trie.word = ''
        for word in words:
            trie.insert(word)
        
        maxLen = 0
        output = ""
        q = deque([trie])
        while(q):
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if(curr is not None and curr.word is not None):
                    for child in curr.children:
                        if child is not None:
                            q.append(child)
                    if(len(curr.word) > maxLen):
                        output = curr.word
                        maxLen = len(curr.word)
        return output