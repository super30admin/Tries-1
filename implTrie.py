class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False
        
class Trie:
        

    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        temp = self.root 
        for c in word:
            new_node = TrieNode()
            if temp.children[ord(c) - ord('a')] is None:
                temp.children[ord(c) - ord('a')] = new_node
            temp = temp.children[ord(c) - ord('a')]
        
        temp.isEnd = True
                
        

    def search(self, word: str) -> bool:
        temp = self.root
        for c in word:
            if temp.children[ord(c) - ord('a')] is None:
                return False
            temp = temp.children[ord(c) - ord('a')]
        return temp.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        temp = self.root
        for c in prefix:
            if temp.children[ord(c) - ord('a')] is None:
                return False
            temp = temp.children[ord(c) - ord('a')]
        return True
        
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)