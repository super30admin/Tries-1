'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 648. Replace Words

# https://leetcode.com/problems/replace-words/

#-----------------
# Time Complexity: 
#-----------------
# O(NM) - N is the length of the sentence. M is the max key size

#------------------
# Space Complexity: 
#------------------
# O(N): Size of the trie

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

class Solution:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        # Trie Class will have a Root TrieNode
        # All the words in the dictionary will start here
        self.root = TrieNode()
        return

    def insert(self, word: str) -> None:
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

    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        # Solution() : Trie()
        
        for word in dictionary:
            self.insert(word)
        
        split_sent = sentence.split()
        result = []
        
        for word in split_sent:
            replacement = ""
            curr = self.root
            for i in range(len(word)):
                c = word[i]
                
                # Need to handle these two cases separately
                if curr.children[ord(c)-ord('a')] is None or curr.isEnd:
                    break
                
                curr = curr.children[ord(c) - ord('a')]
                replacement += c
            
            # Handle the case where there is a root word
            # in the Trie
            if curr.isEnd:
                # Append the root word as replacement in the
                # resultant sentence
                result.append(replacement)

            # In any other case, keep the same word in the
            # resultant sentence
            else:
                result.append(word)
        
        return " ".join(result)
