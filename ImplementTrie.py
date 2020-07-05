# Time Complexty : O(1) for search and insert but O(N) for doing search with
#Space Complecity : O(N)

class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.triedict = {}

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        self.triedict[word] = word

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        if word in self.triedict:
                return True
        return False

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        for word in self.triedict:
            if self.triedict[word].startswith(prefix):
                return True
        return False


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
=========================================================
# Time Complexty : O(N) where N is number of characters in string
#Space Complecity : O(N) where N is number of characters in string
class TrieNode:
    def __init__(self,val):
        self.val =val
        self.children =[None]*26
        self.isword =False
        
class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode(" ")

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        temp = self.root
        for i in word:
            node = TrieNode(i)
            if temp.children[ord(i)-ord('a')] == None:
                temp.children[ord(i)-ord('a')] =node
            temp = temp.children[ord(i)-ord('a')]
        temp.isword=True

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        temp = self.root
        for i in word:
            if temp.children[ord(i)-ord('a')] == None:
                return False
            temp = temp.children[ord(i)-ord('a')]
        return temp.isword

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        temp = self.root
        for i in prefix:
            if temp.children[ord(i)-ord('a')] == None:
                return False
            temp = temp.children[ord(i)-ord('a')]
        return True



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)