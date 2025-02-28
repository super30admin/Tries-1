class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False


class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    # TC : O(l)
    # SC : O(l)
    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """

        curr = self.root
        for ch in word:
            if curr.children[ord(ch) - ord('a')] is None:
                curr.children[ord(ch) - ord('a')] = TrieNode()
            curr = curr.children[ord(ch) - ord('a')]
        curr.isEnd = True

    # TC : O(l)
    # SC : O(1)
    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        curr = self.root
        for ch in word:
            if curr.children[ord(ch) - ord('a')] is None:
                return False
            curr = curr.children[ord(ch) - ord('a')]
        return curr.isEnd

    # TC : O(l)
    # SC : O(1)
    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        curr = self.root
        for ch in prefix:
            print(ch)
            print(ord(ch) - ord('a'))
            print(curr.children[ord(ch) - ord('a')])
            print(curr.children)
            if curr.children[ord(ch) - ord('a')] is None:
                print("inside if")
                return False
            curr = curr.children[ord(ch) - ord('a')]
        return True
