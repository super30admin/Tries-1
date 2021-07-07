# Time Complexity : Insert : O(n), Search: O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

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
        node = self.root
        for i in range(len(word)):
            if node.children[ord(word[i]) - ord('a')] is None:
                node.children[ord(word[i]) - ord('a')] = TrieNode()
            node = node.children[ord(word[i]) - ord('a')]
        node.isEnd = True
            
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root
        for i in range(len(word)):
            if node.children[ord(word[i]) - ord('a')] is None:
                return False
            node = node.children[ord(word[i]) - ord('a')]
        return node.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        for i in range(len(prefix)):
            if node.children[ord(prefix[i]) - ord('a')] is None:
                return False
            node = node.children[ord(prefix[i]) - ord('a')]
        return True
        
class TrieNode:
    
    def __init__(self):
        self.children = [None for _ in range(26)]
        self.isEnd = False

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)