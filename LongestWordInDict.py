# TC: O(mn)
# SC: O(mn)
# Will create Trie node structure using words provided. Now coming to main task- BFS is ideal for this as we can ascertain at lexical order at each level
# BFS: We traverse in such as way that word associated with my last node should give me my answer! This saves the pain to check lexical order or chars in case of tie situations. First, appned root to queue. Then start appending nodes to the queue from the last child of the root(if only if it is end of a given word *Note: We need to find the longest word which is successively built using other input words) and so on. The last node that gets popped off the queue contains your answer. 
class TrieNode:
    def __init__(self):
        self.word = None
        self.children = [None] * 26

from collections import deque
class Solution:
    def insert(self, word):
        curr = self.root
        for ch in word:
            if curr.children[ord(ch) - ord('a')] == None:
                curr.children[ord(ch) - ord('a')] = TrieNode()
            curr = curr.children[ord(ch) - ord('a')]
        curr.word = word

    def longestWord(self, words):
        if not words or len(words) == 0:
            return ""   
        # Build Trie using words provided
        self.root  = TrieNode()
        for word in words:
            self.insert(word)
        # BFS
        q = deque()
        curr = self.root
        q.append(self.root)
        while q:
            curr = q.popleft()
            for i in range(25, -1, -1):
                if curr.children[i] != None and curr.children[i].word != None:
                    q.append(curr.children[i])
        # No word found
        if curr is None:
            return ""
        return curr.word
        
        
        