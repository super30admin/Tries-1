class TrieNode(object):

    def __init__(self):
        self.childNodes = [None for i in range(26)]
        self.isEnd = False
    
class Trie(object):

    def __init__(self):
        self.node = TrieNode()
        

    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        parent_node = self.node
        for w in word:
            if not parent_node.childNodes[ord(w)-ord('a')]:
                parent_node.childNodes[ord(w)-ord('a')] = TrieNode()
            parent_node = parent_node.childNodes[ord(w)-ord('a')]
        parent_node.isEnd=True
        

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        parent_node = self.node
        for w in word:
            if not parent_node.childNodes[ord(w)-ord('a')]:
                return False
            parent_node = parent_node.childNodes[ord(w)-ord('a')]
        if parent_node.isEnd:
            return True
        

    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        parent_node = self.node
        for w in prefix:
            if parent_node.childNodes[ord(w)-ord('a')]:
                parent_node = parent_node.childNodes[ord(w)-ord('a')]
            else:
                return False
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)