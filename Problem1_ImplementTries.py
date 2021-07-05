'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 208. Implement Trie (Prefix Tree)

# https://leetcode.com/problems/implement-trie-prefix-tree/


#-----------------
# Time Complexity: 
#-----------------
# O(L) - Where L is the length of the key

#------------------
# Space Complexity: 
#------------------
# O(1): Constant space

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

class Trie:
    
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

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        #Start at root
        curr = self.root
        for i in range(len(word)):
                              
            c = word[i]
            if curr.children[ord(c)-ord('a')] is None:
                # If the required alphabet is not found in
                # any of the prefixes, then return False
                # Search failed.
                return False
            curr = curr.children[ord(c) -ord('a')]
                    
        # Return if a word ends here.
        # If we only have the prefix, it's not enough
        return curr.isEnd                             


    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for i in range(len(prefix)):
                              
            c = prefix[i]
            if curr.children[ord(c)- ord('a')] is None:
                return False
            
            curr = curr.children[ord(c) - ord('a')]
        
        # Return True here because
        # prefix is found
        return True



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)