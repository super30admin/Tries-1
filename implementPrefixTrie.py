"""
w = maxlen of a word
search: O(w)
startsWith: O(w)
insert: O(w)

"""
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for i in range(26)]

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        root = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if not root.children[idx]:
                root.children[idx] = TrieNode()
            root = root.children[idx]
        root.isEnd = True
        

    def search(self, word: str) -> bool:
        root = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if not root.children[idx]:
                return False
            root = root.children[idx]
        if not root.isEnd:
            return False
        return True
        

    def startsWith(self, prefix: str) -> bool:
        root = self.root
        for c in prefix:
            idx = ord(c) - ord('a')
            if not root.children[idx]:
                return False
            root = root.children[idx]
        return True
        
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)