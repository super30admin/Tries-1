# Using an Array of size 26 to store characters at each level.
class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.word = None
        self.children = [None]*26

    # Time Complexity is O(n), 
    # Space Complexity is O(n) where n is the size of the word
    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        curr = self
        for i in range(len(word)):
            c = word[i]
            if(curr.children[ord(c) - ord('a')] == None):
                curr.children[ord(c) - ord('a')] = Trie()
            curr = curr.children[ord(c)-ord('a')]
        curr.word = word

    # Time Complexity is O(n), where n is the size of the word
    # Space Complexity is O(1)
    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        curr = self
        for c in word:
            index = ord(c) - ord('a')
            if(curr.children[index] == None):
                return False
            curr = curr.children[index]
        return curr.word is not None

    # Time Complexity is O(n), where n is the size of the prefix
    # Space Complexity is O(1)
    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        curr = self
        for c in prefix:
            index = ord(c) - ord('a')
            if(curr.children[index] == None):
                return False
            curr = curr.children[index]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)