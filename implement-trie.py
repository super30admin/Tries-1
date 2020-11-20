# Time Complexity: O(l) - length of word for insert, search, starts with
# Space Complexity: O(1) - No auxillary space used
# Approach: Represent a trie node as an array of TrieNodes(26, lower case chars) and a bool field to represent end of word.
# A TrieNode consists of a map - <char:TreeNode> and a boolean to specify end of word
class TrieNode():
    def __init__(self):
        self.children = [None]*26
        self.endOfWord = False
        
        
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
        # Get the root of the trie
        current = self.root
        # Traverse the trie till the prefix of the word is found
        for char in word:
            node = current.children[ord(char)-ord('a')]
            if node is None: # Create a new trie node starting with the suffix of the word
                node = TrieNode()
                current.children[ord(char)-ord('a')] = node
            current = node
        # Mark end of word to true
        current.endOfWord = True
            

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        current = self.root
        for char in word:
            node = current.children[ord(char)-ord('a')]
            if node is None:
                return False
            current = node
        return current.endOfWord
            
        

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        current = self.root
        for char in prefix:
            node = current.children[ord(char)-ord('a')]
            if node is None:
                return False
            current = node
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)