class Trie:
    class TrieNode():
        def __init__(self):
            self.children={}
            self.isEnd=False

    def __init__(self):
        self.root=self.TrieNode()
        

    def insert(self, word: str) -> None:
        curr=self.root
        for c in word:
            if curr.children.get(c) is None:
                curr.children[c]=self.TrieNode()
            curr=curr.children[c]
        curr.isEnd=True


    def search(self, word: str) -> bool:
        curr=self.root
        for c in word:
            if curr.children.get(c) is None:
                return False
            curr=curr.children[c]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr=self.root
        for c in prefix:
            if curr.children.get(c) is None:
                return False
            curr=curr.children[c]
        return True

        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)