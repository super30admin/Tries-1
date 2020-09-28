# Time Complexity : O(n)
# Space Complexity : O(m) m = no. chars in Trie
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Trie(object):
    
    class TrieNode():
        def __init__(self):
            self.children = {}
            #isWord is to detect whether the word is inserted or not
            self.isWord = False

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = self.TrieNode()
        

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        curr = self.root
        for c in word:
            if c not in curr.children:
                #create a trienode for every value present in the array
                curr.children[c] = self.TrieNode()
            curr = curr.children[c]
        curr.isWord = True
        

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        curr = self.root
        for c in word:
            if c not in curr.children:
                return False
            curr = curr.children[c]
            
        
        return curr.isWord
        

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        curr = self.root
        for c in prefix:
            if c not in curr.children:
                return False
            curr = curr.children[c]
        
        return True
            