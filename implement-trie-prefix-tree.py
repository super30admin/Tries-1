'''
TC: insert - O(L) - longest word, search, prefix
SC: O(n*W) - number of words, average length of words
'''
class Trie(object):

    def __init__(self):
        self.trie = dict()
        

    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        temp = self.trie
        for letter in word:
            if letter in temp:
                temp = temp[letter]
            else:
                temp[letter] = dict()
                temp = temp[letter]
        temp["."] = {}
                
        

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        temp = self.trie
        for letter in word:
            if letter in temp:
                temp = temp[letter]
            else:
                return False
        return True if "." in temp else False

    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        temp = self.trie
        for letter in prefix:
            if letter in temp:
                temp = temp[letter]
            else:
                return False
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)