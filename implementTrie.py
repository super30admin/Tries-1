#Time Complexity: O(N)
#Space Complexity: O(M)
#Run on Leetcode: Yes
#Any Issues: No

class TrieNode:
    def __init__(self):
        self.child = {}
        self.end = False
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
        parent = self.root
        for c in word:
            if not c in parent.child:
                parent.child[c] = TrieNode()
            parent = parent.child[c]
        parent.end = True
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        parent = self.root
        for c in word:
            if not c in parent.child:
                return False
            parent = parent.child[c]
        return parent.end
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        parent = self.root
        for c in prefix:
            if not c in parent.child:
                return False
            parent = parent.child[c]
        return True