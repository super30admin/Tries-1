# Created by Aashish Adhikari at 6:33 PM 2/2/2021

'''
Time Complexity:
insert() : O(n)
search() : O(n)
startsWith() : O(n)


Space Complexity:
insert() : O(1)
search() : O(1)
startsWith() : O(1)

'''

class Node(object):

    def __init__(self):

        self.children = [0 for idx in range(26)]
        self.hasWord = False


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
        curr = self.root

        for idx in range(len(word)):

            if curr.children[ord(word[idx]) - ord("a")] != 0:
                curr = curr.children[ord(word[idx]) - ord("a")]
            else:
                curr.children[ord(word[idx]) - ord("a")] = Node()
                curr = curr.children[ord(word[idx]) - ord("a")]

        curr.hasWord = True







    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """

        curr = self.root

        for idx in range(len(word)):

            if curr.children[ord(word[idx]) - ord("a")] != 0:
                curr = curr.children[ord(word[idx]) - ord("a")]
            else:
                return False
        # there could be a case that this letter exists but the word ending here was not inserted before.
        return curr.hasWord


    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """

        curr = self.root

        for idx in range(len(prefix)):

            if curr.children[ord(prefix[idx]) - ord("a")] != 0:
                curr = curr.children[ord(prefix[idx]) - ord("a")]
            else:
                return False
        return True



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)