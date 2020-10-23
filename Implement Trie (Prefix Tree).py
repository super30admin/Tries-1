# TC: O(n)
# SC: O(1)
# Yes, it ran on leetcode
# No problems
import collections
class TrieNode():
    def __init__(self):
        self.nodes = collections.defaultdict(TrieNode)
        self.isword = False

class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        curr = self.root
        for ch in word:
            curr = curr.nodes[ch]
        curr.isword = True
        

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        curr = self.root
        for ch in word:
            if ch not in curr.nodes:
                return False
            curr = curr.nodes[ch]
        return curr.isword
        

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        curr = self.root
        for ch in prefix:
            if ch not in curr.nodes:
                return False
            curr = curr.nodes[ch]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)