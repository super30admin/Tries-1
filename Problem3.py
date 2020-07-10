"""
// Time Complexity : in code
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
"""

class TrieNode:
    def __init__(self):
        self.isEnd = False
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

        Time: o(L), L -> avg length of words in dictionary
        """
        cur = self.root
        for i in word:
            node = TrieNode()
            idx = ord(i) - ord('a')
            if not cur.children[idx]:
                cur.children[idx] = node
            cur = cur.children[idx]
            
        cur.isEnd = True
    
        
class Solution(object):
   
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str

        Time: o(n*L), L -> avg length of words in dictionary,  n -> number of words in sentence
        """
        words = sentence.split(" ")  # list of words in the sentence
        
        trie = Trie()
        
        for w in dict: #form a trie of the dictionary
            trie.insert(w)
            
        root = trie.root
        
        res = ""
        
        for w in words: #for each word
            cur = root
            replace = ""
            f = False
            
            for i in w: #for each character in word
                replace += i
                idx = ord(i) - ord('a')
                
                if not cur.children[idx]: #if at any point a character is missing in trie
                    res += w + " " # add the original word to result
                    f = True
                    break
                cur = cur.children[idx]
                if cur.isEnd: #if the word is found, replace the word 
                    res += replace + " " 
                    f = True
                    break
            if not cur.isEnd and not f: #if only the prefix of the word is found, still add the original word to the result
                res += w + " "
                
        return res.strip() #remove the space at the end
        
        
            
        