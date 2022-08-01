class Node:
    def __init__(self):
        self.children=[None for _ in range(26)]
        self.is_end=False
        
class Trie:

    def __init__(self):
        self.root=Node()
        
    def insert(self, word: str) -> None:
        current=self.root
        for i in word:
            if current.children[ord(i)-ord('a')] is None:
                current.children[ord(i)-ord('a')]=Node()
                
            current=current.children[ord(i)-ord('a')]
            
        current.is_end=True

    def search(self, word: str) -> bool:
        current=self.root
        for i in word:
            if current.children[ord(i)-ord('a')] is None:
                return False
            
            current=current.children[ord(i)-ord('a')]
        return current.is_end

    def startsWith(self, prefix: str) -> bool:
        current=self.root
        for i in prefix:
            if current.children[ord(i)-ord('a')] is None:
                return False
            
            current=current.children[ord(i)-ord('a')]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)