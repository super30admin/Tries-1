class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children=[None]*26

class Trie:
        
    def __init__(self):
        self.root = TrieNode()     

    def insert(self, word: str) -> None:
        curr = self.root
        for ch in range(len(word)):
            if curr.children[ord(word[ch]) - ord('a')] == None:
                curr.children[ord(word[ch]) - ord('a')]= TrieNode()
            curr = curr.children[ord(word[ch]) - ord('a')]
        curr.isEnd = True    
            

    def search(self, word: str) -> bool:
        curr = self.root
        for ch in range(len(word)):
            if curr.children[ord(word[ch]) - ord('a')] == None:
                return False;
            curr =  curr.children[ord(word[ch]) - ord('a')]
        return curr.isEnd    

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for ch in range(len(prefix)):
            if curr.children[ord(prefix[ch]) - ord('a')] == None:
                return False
            curr = curr.children[ord(prefix[ch]) - ord('a')]
        return True    
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
