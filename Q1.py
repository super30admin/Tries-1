############# Implement Prefix Tree

# Time Complexity :  Insert -> O(n), Search -> O(n) and startsWith -> O(n)
# Space Complexity : O(26*h) where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Every level is a dictionary for alphabets a-z and keep adding the words to the tree structure and keeping track of if it is the end.

class TrieNode():
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False

class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        current = self.root
        for c in word:
            if c not in current.children:
                current.children[c] = TrieNode()
            current = current.children[c]
        current.is_end_of_word = True
        
    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        current = self.root
        for c in word:
            if c not in current.children:
                return False
            current = current.children[c]
        return current.is_end_of_word

    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        current = self.root
        for c in prefix:
            if c not in current.children:
                return False
            current = current.children[c]
        return True
