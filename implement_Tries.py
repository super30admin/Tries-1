"""
Time Complexity : insert() - O(n)   
                  search() - O(n)
                  startsWith() - O(n)
Space Complexity : insert() - O(n)
                   search() - O(1)
                   startsWith() - O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Leetcode kept giving me issues, even though my 
                                          code was correct (testcase running issues)
"""

class Trie:
    class TrieNode:
        def __init__(self):
            self.children = [None]*26
            self.isEnd = False
        
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for i in range(len(word)):
            idx = ord(word[i]) - ord('a')
            if not curr.children[idx]:
                curr.children[idx] = self.TrieNode()
            curr = curr.children[idx]
        
        curr.isEnd = True
        
    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for i in range(len(word)):
            idx = ord(word[i]) - ord('a')
            if not curr.children[idx]:
                return False
            curr = curr.children[idx]
            
        return curr.isEnd
                    
    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for i in range(len(prefix)):
            idx = ord(prefix[i]) - ord('a')
            if not curr.children[idx]:
                return False
            curr = curr.children[idx]
            
        return True
    
t = Trie()
t.insert("apple")
print(t.search("a"))