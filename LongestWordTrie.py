"""
720. Longest Word in Dictionary

Time = O(m) where m = length of the words[i] to buld Trie and search
Space = O(m) to create and store Trie
Successfully excecuted on leetcode


Approach:
1. Create Trie and insert all words in input array. 
2. After inserting all words, iterate through character by character in words and check if all the combination exist in Trie using recursion

"""

class TrieNode:
    def __init__(self):
        self.children = {}
        self.end = False
        
class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        cur = self.root
        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
        cur.end = True
    
    def longest_word(self):
        def helper(node, partial_res):
            # base
            res = partial_res
            
            for c, child in node.children.items():
                if child.end:
                    pot = helper(child, partial_res + c)
                    if len(pot) > len(res):
                        res = pot
                    elif len(pot) == len(res) and pot < res:
                        res = pot
            return res
        return helper(self.root, '')

class Solution:
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        T = Trie()
        for word in words:
            T.insert(word)
        return T.longest_word()