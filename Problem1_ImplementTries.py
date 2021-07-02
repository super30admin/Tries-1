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
        # print(curr.children)
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c) - ord('a')] is None:
                curr.children[ord(c)-ord('a')] = self.TrieNode() 
            curr = curr.children[ord(c)-ord('a')]
        
        curr.isEnd = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for i in range(len(word)):
                              
            c = word[i]
            if curr.children[ord(c)-ord('a')] is None:
                return False
            curr = curr.children[ord(c) -ord('a')]
                    
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
        
        return True



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)