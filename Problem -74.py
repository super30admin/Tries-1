# Leet code - 208 - Implement Trie - https://leetcode.com/problems/implement-trie-prefix-tree/
# Time complexity for any operation in Trie is O(N)
# we take other DS like hashmaps and arrays there can be both time and space issues
# if in case of balanced binary search tree also the time complexity is M*log(N)



class TrieNode:
    def __init__(self):
        
        self.isEndOfWord=False
        self.children={}

class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root= TrieNode()
        
    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        node=self.root
        for c in word:
            if c not in node.children:
                node.children[c]= TrieNode()
            node=node.children[c]
            
        node.isEndOfWord=True

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        node=self.root
        for c in word:
            if c in node.children:
                node=node.children[c]
            else:
                return False
        if not node.isEndOfWord:
            return False
        return True

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        node=self.root
        for c in prefix:
            if c in node.children:
                node=node.children[c]
            else:
                return False
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)