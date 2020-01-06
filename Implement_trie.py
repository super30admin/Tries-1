# Runs on Leetcode

    # Runtime 
        # Insertion - O(1)
        # Search and startswith operation - O(n) where n is length of the word whcih s to be searched
        
    # Memory - O(n) where n is sum of length of words with different first letters

class Trie:
    class TrieNode:
        def __init__(self):
            self.isEnd = False
            self.children = [None]*26
            
    def __init__(self):
        self.root = self.TrieNode()
        
    def insert(self, word):
        node = self.root
        for i in word:
            if not node.children[ord(i) - ord('a')]:
                node.children[ord(i) - ord('a')] = self.TrieNode()
            node = node.children[ord(i) - ord('a')]
        node.isEnd = True

    def search(self, word):
        node = self.root
        for i in word:
            if node.children[ord(i) - ord('a')]:
                node = node.children[ord(i) - ord('a')]
            else:
                return False
        if node.isEnd:
            return True
        return False
                
    def startsWith(self, prefix):
        node = self.root
        for i in prefix:
            if node.children[ord(i) - ord('a')]:
                node = node.children[ord(i) - ord('a')]
            else:
                return False
        return True
         
