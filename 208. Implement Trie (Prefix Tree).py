# // Time Complexity : O(L) for all operation
# // Space Complexity : O(L)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.TrieChidern = [None] * 26
        
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        CurrNode = self.root
        for c in word:
            if CurrNode.TrieChidern[ord(c)-ord('a')] == None:
                CurrNode.TrieChidern[ord(c)-ord('a')] = TrieNode()
            CurrNode = CurrNode.TrieChidern[ord(c)-ord('a')]
        CurrNode.isEnd = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        CurrNode = self.root
        for c in word:
            if CurrNode.TrieChidern[ord(c)-ord('a')] != None:
                CurrNode = CurrNode.TrieChidern[ord(c)-ord('a')]
            else:
                return False
        return CurrNode.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        CurrNode = self.root
        for c in prefix:
            if CurrNode.TrieChidern[ord(c)-ord('a')] != None:
                CurrNode = CurrNode.TrieChidern[ord(c)-ord('a')]
            else:
                return False
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)