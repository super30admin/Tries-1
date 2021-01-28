'''
Solution:
Solutions of individual functions are explained in respective methods along with Time and Space Complexities.

--- Passed all testcases on Leetcode successfully
'''

class TrieNode(object):

    def __init__(self):
        self.charNodes = [None for i in range(26)]
        self.isEnd = False


class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.rootNode = TrieNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """

        # O(n) Time Complexity | O(n) max extra space Complexity (not always)

        #   initialize to the root of the trie as current node
        currNode = self.rootNode

        #   traverse the trie until we hit the length of word to be inserted
        for i in range(len(word)):
            currChar = word[i]
            if (currNode.charNodes[ord(currChar) - ord('a')] == None):      #   if the next character doesn't exist in Trie => add the char to Trie
                currNode.charNodes[ord(currChar) - ord('a')] = TrieNode()
            currNode = currNode.charNodes[ord(currChar) - ord('a')]
        currNode.isEnd = True                                               #   make last char to be the one of the ending chars in the Trie

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        # O(n) Time Complexity | O(1) Space Complexity

        #   initialize to the root of the trie as current node
        currNode = self.rootNode

        #   traverse the trie until we hit the length of word to be searched
        for i in range(len(word)):
            currChar = word[i]
            if (currNode.charNodes[ord(currChar) - ord('a')] == None):      #   if the next character doesn't exist in Trie => return false
                return False
            currNode = currNode.charNodes[ord(currChar) - ord('a')]
        return currNode.isEnd                                               #   if all characters are present in Trie => return True if the last char is ending char

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        # O(n) Time Complexity | O(1) Space Complexity

        #   initialize to the root of the trie as current node
        currNode = self.rootNode

        #   traverse the trie until we hit the length of prefix to be searched
        for i in range(len(prefix)):
            currChar = prefix[i]
            if (currNode.charNodes[ord(currChar) - ord('a')] == None):      #   if the next character doesn't exist in Trie => return false
                return False
            currNode = currNode.charNodes[ord(currChar) - ord('a')]
        return True                                                         #   if all characters are present in Trie => return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)