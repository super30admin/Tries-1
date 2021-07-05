'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 720. Longest Word in Dictionary

# https://leetcode.com/problems/longest-word-in-dictionary/


#-----------------
# Time Complexity: 
#-----------------
# O(L) - Where L is the length of the key

#------------------
# Space Complexity: 
#------------------
# O(L): Need to store the characters of the word in an array

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution:
    

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = {}
        self.longest_word = ""
        

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            if c not in curr:
                curr[c] = {}
            curr = curr[c]
        
        curr["is_word"] = True        
        curr["index"] = index
        

    def longestWord(self, words: List[str]) -> str:
                
        for index, word in enumerate(words):
            self.insert(word, index)
                
        stack = [child for child in self.root if type(child) is dict]
        while len(stack) > 0:
            curr = stack.pop()
            if "is_word" in curr:
                word = words[curr["index"]]
                if self.longest_word == "" or \
                        len(word) > len(self.longest_word) or \
                        (len(word) == len(self.longest_word) and word < self.longest_word):
                    self.longest_word = word
                
                for child in curr:
                    if type(child) is dict:
                        stack.append(child)
                            
        return self.longest_word