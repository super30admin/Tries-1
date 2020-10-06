"""
720. Longest Word in Dictionary

Time = O(n) where n = length of the sentence
Space = O(n) to create and store Trie
Successfully excecuted on leetcode


Approach:
1. Create Trie and insert all words in input dictionary. 
2. After inserting all words, Then for each word, look at successive prefixes of that word.
    If you find a prefix that is a root, replace the word with that prefix.
    Else, the prefix will just be the word itself, and we should add that to the final sentence answer.
"""

class TrieNode():
    def __init__(self):
        self.chars = {}
        self.is_word=False
class Trie(object):
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, s):
        node = self.root
        for c in s:
            if c not in node.chars:
                node.chars[c] = TrieNode()
            node = node.chars[c]
        node.is_word=True
    
    def findprefix(self, s):
        node = self.root
        out = ''
        for c in s:
            if c not in node.chars:
                break
            node = node.chars[c]
            out+=c
            if node.is_word:
                return out
        return s 
    
class Solution:
    def replaceWords(self, dict: List[str], sentence: str) -> str:
        
        trie = Trie()
        for c in dict:
            trie.insert(c)
        out = ''
        for e in sentence.split():
            if len(out)>0:
                out+=' '
            out+=trie.findprefix(e)
        return out 
                
        