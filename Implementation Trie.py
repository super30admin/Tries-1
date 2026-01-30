class TrieNode:
        def __init__(self):
            self.children=[None]*26
            self.is_end=False

class Trie:
   

    def __init__(self):
        self.root=TrieNode()

    def insert(self, word: str) -> None:
        node=self.root
        for char in word:
            index=ord(char)-ord('a')
            if node.children[index]==None:
                node.children[index]=TrieNode()
            node=node.children[index]

        node.is_end=True
    def search(self, word: str) -> bool:
        node=self.root
        for char in word:
            index=ord(char)-ord('a')
            if node.children[index]==None:
                return False
            node=node.children[index]
        return node.is_end
        

    def startsWith(self, prefix: str) -> bool:
        node=self.root
        for char in prefix:
            index=ord(char)-ord('a')
            if node.children[index]==None:
                return False
            node=node.children[index]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)