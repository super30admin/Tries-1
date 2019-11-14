'''
https://leetcode.com/problems/implement-trie-prefix-tree/

Did it run Leetcode: Yes
Did you face any difficulty: How to mark the end of the character search

Algorithm:
It is same as n-ary tree, instead of linked lists we will
have hashmap or dictinary. 
If considred for english each node can have max of 26 childs.
- a `#` is used to mark the end of the dictionary.

'''
class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.trie = dict()
        

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        wordMap = self.trie
        for char in word:
            if not char in wordMap:
                wordMap[char]=dict()
            wordMap = wordMap.get(char)
        
        # to mark the end of string
        wordMap["#"] = "#"
                
        

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        wordMap = self.trie.copy()
        for char in word:
            if char in wordMap:
                wordMap = wordMap.get(char)
            else:
                return False
        
        return True if "#" in wordMap else False
        

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        wordMap = self.trie.copy()
        for char in prefix:
            if char in wordMap:
                wordMap = wordMap.get(char)
            else:
                return False
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)