##Time Complexity : O(L)-, Here l=length of word
##Space Complexity : O(1)
##Did this code successfully run on Leetcode : Yes
class Trie(object):
    
    def __init__(self):
        self.children = defaultdict(Trie)
        self.isWord = False
        

    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        current = self
        for c in word:
            current = current.children[c]
        current.isWord = True
        

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        current = self
        for c in word:
            if c not in current.children:
                return False
            current = current.children[c]
        return current.isWord
        

    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        current = self
        for c in prefix:
            if c not in current.children:
                return False
            current = current.children[c]
        return True
        