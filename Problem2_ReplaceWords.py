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

class Solution:
    
    class Trie:
    
        class TrieNode:
            def __init__(self):
                self.isEnd = False
                self.children = [None for i in range(26)]

        def __init__(self):
            """
            Initialize your data structure here.
            """


            self.root = self.TrieNode()
            return

        def insert(self, word: str) -> None:
            """
            Inserts a word into the trie.
            """
            curr = self.root
            for i in range(len(word)):
                c = word[i]
                if curr.children[ord(c) - ord('a')] is None:
                    curr.children[ord(c)-ord('a')] = self.TrieNode() 
                curr = curr.children[ord(c)-ord('a')]

            curr.isEnd = True
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.root = self.Trie()
        for word in dictionary:
            self.root.insert(word)
        
        split_sent = sentence.split()
        result = []
        for word in split_sent:
            replacement = ""
            curr = self.root.root
            for i in range(len(word)):
                c = word[i]
                if curr.children[ord(c)-ord('a')] is None or curr.isEnd:
                    
                    break
                curr = curr.children[ord(c) - ord('a')]
                replacement += c
                
            if curr.isEnd:
                #Found smallest prefix in the sentence
                result.append(replacement)

            else:
                #Didn't find prefix of word in dictionary
                result.append(word)
        
        return " ".join(result)
