class TrieNode:
    def __init__(self, val):
        self.val = val
        self.child = defaultdict(TrieNode)
        self.end = False

class Trie(object):

    def __init__(self):
        self.root = TrieNode(None)

    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        root = self.root
        for ch in word:
            if ch not in root.child:
                root.child[ch] = TrieNode(ch)
            root = root.child[ch]
        root.end = True

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        root = self.root
        for ch in word:
            if ch not in root.child:
                return False
            root = root.child[ch]
        if root.end:
            return True
        return False
        

    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        root = self.root
        for char in prefix:
            if char not in root.child:
                return False
            root = root.child[char]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)