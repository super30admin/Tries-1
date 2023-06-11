#Time Complexity:O(n)
#Space Complexity:O(1)

class TrieNode:
    def __init__(self):
        self.children=[None]*26
        self.isEnd=False

class Trie(object):

    def __init__(self):
        self.root=TrieNode()
        

    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        curr=self.root
        for i in word:
            if curr.children[ord(i)-ord('a')]==None:
                curr.children[ord(i)-ord('a')]=TrieNode()
            curr=curr.children[ord(i)-ord('a')]
        curr.isEnd=True

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        node=self.root
        for char in word:
            if not node.children[ord(char)-ord('a')]:
                return False
            node=node.children[ord(char)-ord('a')]
        return node.isEnd

    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        node=self.root
        for char in prefix:
            if not node.children[ord(char)-ord('a')]:
                return False
            node=node.children[ord(char)-ord('a')]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)