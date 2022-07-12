#208. Implement Trie (Prefix tree)
"""
Time Complexity : O(L) L = lenght of longest word
Space Complexity : O(l * N) N = number of words
"""
class TrieNode:
    isEnd = False
    children = []
    
    def __init__(self):
        self.isEnd = False
        self.children = [None]*26
    
    
class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        
        for i in range(0, len(word)):
            ch = word[i]
            pos = ord(ch) - ord('a')
            
            print()
            if curr.children[pos] == None:
                curr.children[pos] = TrieNode()
                
            curr = curr.children[pos]
        
        curr.isEnd = True
        
    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(0, len(word)):
            ch = word[i]
            pos = ord(ch) - ord('a')
            
            if curr.children[pos] == None:
                return False
                
            curr = curr.children[pos]
        
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(0, len(prefix)):
            ch = prefix[i]
            pos = ord(ch) - ord('a')
            
            if curr.children[pos] == None:
                return False
                
            curr = curr.children[pos]
        
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

