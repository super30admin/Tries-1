class Trie:
    
    class TrieNode:
        def __init__(self):
            self.children = [None]*26
            self.isEnd = False
            
    def __init__(self):
        self.root = self.TrieNode()
        
    #Time Complexity: O(L)
    #Space Complexity: O(L*26)
    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            idx = ord(ch) - ord('a')
            if curr.children[idx] == None:
                curr.children[idx] = self.TrieNode()
            curr = curr.children[idx]
        curr.isEnd = True
        
    #Time Complexity: O(L)
    #Space Complexity: O(1)
    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            idx = ord(ch) - ord('a')
            if curr.children[idx] == None:
                return False
            curr = curr.children[idx]
        return curr.isEnd
    
                   
    #Time Complexity: O(L)
    #Space Complexity: O(1)
    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(len(prefix)):
            ch = prefix[i]
            idx = ord(ch) - ord('a')
            if curr.children[idx] == None:
                return False
            curr = curr.children[idx]
        return True
        

