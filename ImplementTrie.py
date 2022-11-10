class TrieNode:
    def __init__(self):
        self.children = {}
        self.end_of_word = False

class Trie:

    def __init__(self):
        self.root = TrieNode()
    
    # Time Complexity: O(n) where n is the length of word
    # Space Complexity: O(n) where n is the length of word
    def insert(self, word: str) -> None:
        curr = self.root
        
        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
            
        curr.end_of_word = True
    
    # Time Complexity: O(n) where n is the length of word
    # Space Complexity: O(1)
    def search(self, word: str) -> bool:
        curr = self.root
        
        for c in word:
            if c not in curr.children:
                return False
            curr = curr.children[c]
        return curr.end_of_word
    
    # Time Complexity: O(p) where p is the length of Prefix
    # Space Complexity: O(1) 
    def startsWith(self, prefix: str) -> bool:
        
        curr = self.root
        
        for p in prefix:
            if p not in curr.children:
                return False
            curr = curr.children[p]
            
        return True