class Node():
    def __init__(self):
        self._trie = 26 * [None]
        self._isEnd = False


class Trie(object):

    def __init__(self):
        self._root = None
    # Tc = O(n) => length of word
    # Sc = O(n) => length of word

    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        if not self._root:
            self._root = Node()

        current = self._root

        for char in word:
            index = ord(char) - ord('a')

            if not current._trie[index]:
                current._trie[index] = Node()

            current = current._trie[index]

        current._isEnd = True

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        # Tc = O(n) => length of word
        # Sc = O(1)
        current = self._root

        for char in word:
            index = ord(char) - ord('a')
            if not current:
                return False
            if not current._trie[index]:
                return False
            current = current._trie[index]

        if current._isEnd:
            return True
        return False

    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        # Tc = O(n) => length of prefix
        # Sc = O(1)
        current = self._root
        for char in prefix:
            index = ord(char) - ord('a')
            if not current:
                return False
            if not current._trie[index]:
                return False
            current = current._trie[index]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
