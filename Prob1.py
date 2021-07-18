class Trie(object):
    class TrieNode(object):
        children = []
        isEnd = False
        def __init__(self):
            self.children = [None for i in xrange(26)]
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = self.TrieNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        node = self.root
        for ch in word:
            if node.children[ord(ch)-ord('a')] is None:
                node.children[ord(ch)-ord('a')] = self.TrieNode()
            node = node.children[ord(ch)-ord('a')]
        node.isEnd = True

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        node = self.root
        for ch in word:
            if node.children[ord(ch)-ord('a')] is None:
                return False
            node = node.children[ord(ch)-ord('a')]
        return node.isEnd

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        node = self.root
        for ch in prefix:
            if node.children[ord(ch)-ord('a')] is None:
                return False
            node = node.children[ord(ch)-ord('a')]
        return True
        

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
