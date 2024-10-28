
class Trie(object):
    class TrieNode:
        def __init__(self):
            self.isEnd = False
            self.children = [None] * 26

    def __init__(self):
        self.root = self.TrieNode()
        

    def insert(self, word): #T.C = O(L) S.C = O(L)
        """
        :type word: str
        :rtype: None
        """
        curr = self.root
        for c in word:
            if curr.children[ord(c) - ord('a')] == None:
                curr.children[ord(c) - ord('a')] = self.TrieNode()
            curr = curr.children[ord(c) - ord('a')]
        curr.isEnd = True
        
    def search(self, word): #T.C = O(L) S.C = O(1)
        """
        :type word: str
        :rtype: bool
        """
        curr = self.root
        for c in word:
            if curr.children[ord(c) - ord('a')] == None:
                return False
            curr = curr.children[ord(c) - ord('a')]
        return curr.isEnd
        

    def startsWith(self, prefix): #T.C = O(P) S.C = O(1)
        """
        :type prefix: str
        :rtype: bool
        """
        curr = self.root
        for c in prefix:
            if curr.children[ord(c) - ord('a')] == None:
                return False
            curr = curr.children[ord(c) - ord('a')]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)