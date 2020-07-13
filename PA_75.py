#LC 208 - Implement Trie (Prefix Tree)
#Time Complexity - O(n)
#Space Complexity - O(n)
class TrieNode(object):
    
    def __init__(self):
        self.children = dict()
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
        currNode = self.root
        for i in range(len(word)):
            char = word[i]
            if char not in currNode.children:
                currNode.children[char] = TrieNode()
            currNode = currNode.children[char]
        currNode.endOfWord = True

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        currNode = self.root
        for i in range(len(word)):
            char = word[i]
            if char not in currNode.children:
                return False
            currNode = currNode.children[char]
        return currNode.endOfWord

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        currNode = self.root
        for i in range(len(prefix)):
            char = prefix[i]
            if char not in currNode.children:
                return False
            currNode = currNode.children[char]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)