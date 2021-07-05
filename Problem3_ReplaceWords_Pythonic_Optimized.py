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

class Solution(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = {}
        

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
    
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
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
                if c not in curr or "is_word" in curr:
                    break
                
                curr = curr[c]
                replacement += c
            
            # Handle the case where there is a root word
            # in the Trie
            if "is_word" in curr:
                # Append the root word as replacement in the
                # resultant sentence
                result.append(replacement)

            # In any other case, keep the same word in the
            # resultant sentence
            else:
                result.append(word)
        
        return " ".join(result)
