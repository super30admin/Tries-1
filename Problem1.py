"""
## Problem1 
Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)
"""

class TrieNode:
    def __init__(self):
        self.childern = [None] * 26
        self.isEnd = False

class Trie:
    def __init__(self):
        self.childern = [None] * 26
        self.isEnd = False
        self.root = Trie()
    
    def insert(self, word: str) -> None:
        """
        TC : O(N) N is length of word
        SC : O(N)
        """
        curr_node = self.root
        for char in word:
            index = ord(char) - ord('a')
            if curr_node.childern[index] is None:
                curr_node.childern[index] = TrieNode()
            curr_node = curr_node.childern[index]
        curr_node.isEnd = True     

    def search(self, word: str) -> bool:
        """
        TC : O(N)
        SC : O(1)
        """
        curr_node = self.root
        for char in word:
            index = ord(char) - ord('a')
            if curr_node.childern[index] is None:
                return False
            
            curr_node = curr_node.childern[index]
            
        return curr_node.isEnd
        
    def startsWith(self, prefix: str) -> bool:
         """
        TC : O(N)
        SC : O(1)
        """
        curr_node = self.root
        for s in prefix:
            index = ord(s) - ord('a')
            if curr_node.childern[index] is None:
                return False
            curr_node = curr_node.childern[index]
            
        return True
        
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)