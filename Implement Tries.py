class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None]*26
        
class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):  #O(L)
        """
        :type word: str
        :rtype: None
        """
        curr = self.root
        for char in word:
            key = ord(char) - ord('a')
            if curr.children[key] == None:
                curr.children[key] = TrieNode()
            curr = curr.children[key]
        curr.isEnd = True
        

    def search(self, word): #O(L)
        """
        :type word: str
        :rtype: bool
        """
        curr = self.root
        for char in word:
            key = ord(char) - ord('a')
            if curr.children[key]==None:
                return False
            curr = curr.children[key]
            
        return curr.isEnd==True

    def startsWith(self, prefix):  #O(L)
        """
        :type prefix: str
        :rtype: bool
        """
        curr = self.root
        for char in prefix:
            key = ord(char) - ord('a')
            if curr.children[key]==None:
                return False
            curr = curr.children[key]
            
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)