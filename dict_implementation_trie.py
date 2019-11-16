# leetcode 208
#
class Trie_node:
    def __init__(self):  # constructor of trie node
        self.Children = {}  # every trie node has an array of trie nodes # 26 as there are only 26 letters in english alphabet
        self.isEndOfTheWord = False


class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = Trie_node()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        cursor = self.root
        for i in range(len(word)):
            c = str(word[i])

            if not c in cursor.Children:
                node = Trie_node()
                cursor.Children[c] = node
            cursor = cursor.Children[c]

        cursor.isEndOfTheWord = True

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        cursor = self.root
        for i in range(len(word)):
            c = str(word[i])
            # node = Trie_node(c)
            if not c in cursor.Children:
                return False
                # cursor.children[ord(i) - ord('a')] = node
            cursor = cursor.Children[c]

        return cursor.isEndOfTheWord  # as every possible word will have  the end of word set to true

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        cursor = self.root
        for i in range(len(prefix)):
            c = str(prefix[i])
            # node = Trie_node(c)
            if not c in cursor.Children:
                return False
                # cursor.children[ord(i) - ord('a')] = node
            cursor = cursor.Children[c]

        return True