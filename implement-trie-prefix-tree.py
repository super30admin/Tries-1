# Time Complexity: O(l) where l is the length of the word to be inserted/searched/prefix searched
# Space Complexity: O(1) for search and prefix search, O(l) for insert where l is the length of the word to be inserted
# Did this code successfully run on Leetcode: Yes

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False


class Trie(object):

    def __init__(self):
        self.root=TrieNode()
        

    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        curr=self.root
        for ch in word:
            idx=ord(ch)-ord('a')
            if not curr.children[idx]:
                curr.children[idx]=TrieNode()            
            curr=curr.children[idx]
        curr.isEnd=True                                                                     
        

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        curr=self.root
        for ch in word:
            idx=ord(ch)-ord('a')
            if curr.children[idx]:           
                curr=curr.children[idx]
            else:
                return False
        return curr.isEnd 

    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        curr=self.root
        for ch in prefix:
            idx=ord(ch)-ord('a')
            if curr.children[idx]:           
                curr=curr.children[idx]
            else:
                return False
        return True
