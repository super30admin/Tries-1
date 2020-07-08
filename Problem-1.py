# Time Complexity :O(length of longest word)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Node:
    def __init__(self):
        self.children = {}
        self.endOfWord = False

class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = Node()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        #iterate from root
        iterator = self.root
        # for each letter in word
        for i in word:
            # if letter not in children of node add it to children
            if i not in iterator.children:
                iterator.children[i] = Node()
            # go to letter node from children dict
            iterator = iterator.children[i]
        # at end of word set end of word to True
        iterator.endOfWord = True
        

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        #iterate from root
        iterator = self.root
        #for each letter
        for i in word:
            # if you can't find any letter return False
            if i not in iterator.children:
                return False
            else:
                #check rest of letters
                iterator = iterator.children[i]
        #if you find at the end that this is end of word return True else return False
        if iterator.endOfWord == True:
            return True
        return False

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        #iterate from root
        iterator = self.root
        #for each letter in prefix
        for i in prefix:
            # if letter not found return false
            if i not in iterator.children:
                return False
            else:
                #else check rest of letters
                iterator = iterator.children[i]
        #if reached end of pre-fix return True
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)