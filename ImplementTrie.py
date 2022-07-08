# Time Complexity : Insert : O(n), Search: O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -
class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word): #SC: O(1)
        """
        :type word: str
        :rtype: None
        """
        node=self.root
        for i in range(len(word)):
            if node.children[ord(word[i]) - ord('a')] is None:
                node.children[ord(word[i]) - ord('a')] = TrieNode()
            node = node.children[ord(word[i]) - ord('a')]
        node.isEnd = True
        

    def search(self, word): #SC: O(1)
        """
        :type word: str
        :rtype: bool
        """
        node = self.root
        for i in range(len(word)):
            if node.children[ord(word[i]) - ord('a')] is None:
                return False
            node = node.children[ord(word[i]) - ord('a')]
        return node.isEnd
        
        

    def startsWith(self, prefix): #SC: O(1)
        """
        :type prefix: str
        :rtype: bool
        """
        node = self.root
        for i in range(len(prefix)):
            if node.children[ord(prefix[i]) - ord('a')] is None:
                return False
            node = node.children[ord(prefix[i]) - ord('a')]
        return True
        
class TrieNode:
    
    def __init__(self):
        self.children = [None for _ in range(26)]
        self.isEnd = False


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)