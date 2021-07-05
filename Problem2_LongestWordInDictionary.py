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

class TrieNode:
    def __init__(self):
        #isEnd stores whether there is a word
        #in the dict that ends at THIS alphabet
        self.isEnd = False
        
        #Children are lower-case english alphabet
        #If child is 'a', then self.children[0] will not be None
        #But hold another TrieNode()
        self.children = [None for i in range(26)]
        
        self.index = -1
        
class Solution:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        # Trie Class will have a Root TrieNode
        # All the words in the dictionary will start here
        self.root = TrieNode()
        self.longest_word = ""
        return

    def insert(self, word: str, index:int) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        # print(curr.children)
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c) - ord('a')] is None:
                # If TrieNode doesn't exist at this location, create one
                # to add word to dictionary
                curr.children[ord(c)-ord('a')] = TrieNode() 
            # If the prefix already exists in the Trie
            # go to child TrieNode
            curr = curr.children[ord(c)-ord('a')]
        
        # Change isEnd to True to show that
        # there is a word in the dictionary
        # that ends at this node
        curr.isEnd = True
        
        curr.index = index
        

    def longestWord(self, words: List[str]) -> str:
                
        for index, word in enumerate(words):
            self.insert(word, index)
                
        stack = [child for child in self.root.children if child is not None]
        while len(stack) > 0:
            curr = stack.pop()
            if curr.isEnd:
                word = words[curr.index]
                if self.longest_word == "" or \
                        len(word) > len(self.longest_word) or \
                        (len(word) == len(self.longest_word) and word < self.longest_word):
                    self.longest_word = word
                
                for child in curr.children:
                    if child is not None:
                        stack.append(child)
                            
        return self.longest_word