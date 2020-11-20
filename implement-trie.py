class Trie(object):
    from collections import defaultdict
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.c={}
        self.isend=False

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        node=self
        for w in word:
            if w not in node.c:
                node.c[w]=Trie()
            node=node.c[w]
        node.isend=True
            #time-o(m)m-length of prefix space-O(m)


    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        node=self
        for w in word:
            # print(node.c[w])
            if w not in node.c:
                return False
            node=node.c[w]
        return node.isend
    #time-o(m)m-length of word space-O(1)

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        node=self
        for w in prefix:
            if w not in node.c:
                return False
            node=node.c[w]
        # node.isend=True
        return True
        #time-o(m)m-length of prefix space-O(1)

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)