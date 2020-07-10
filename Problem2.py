"""
// Time Complexity : O(L), where L is the avg length of word
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
"""

from collections import deque
class TrieNode:
    def __init__(self):
        self.word = ""
        self.children = [None for _ in range(26)]
        
class Trie:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        
    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        cur = self.root
        for i in word:
           
            idx = ord(i) - ord('a')
            if not cur.children[idx]:
                node = TrieNode()
                cur.children[idx] = node
            cur = cur.children[idx] 
        cur.word = word #store the word along the path for complete words, will be used to return the longest word in the end
        
class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        trie = Trie()
        
        for w in words: #insert words into the trie
            trie.insert(w)
            
        root = trie.root #get the root of trie
       
        q = deque() # q for level order traversal of trie
        
        q.append(root)
        
        while q:
            cur = q.popleft()
            
            for i in range(25,-1,-1): #add children in reverse order to take care of lexicographical order
                if cur.children[i] and cur.children[i].word: #add only those children which are complete words 
                    q.append(cur.children[i])
        return cur.word # the return the word associated with final node
            
        