# problem 1
# https://leetcode.com/problems/implement-trie-prefix-tree/

class Trie:
    class TriNode:
        def __init__(self):
            self.node = [None]*26 # since we will have 26 words
            self.end_word = False

    def __init__(self):
        self.root = self.TriNode()

    def insert(self, word: str) -> None:
        current = self.root
        for i in word:
            idx = ord(i) - ord('a')
            if current.node[idx] is None:
                current.node[idx] = self.TriNode()
            current = current.node[idx]
        current.end_word = True

    def search(self, word: str) -> bool:
        current = self.root
        for i in word:
            idx = ord(i) - ord('a')
            if current.node[idx] is None:
                return False 
            current = current.node[idx]
        return current.end_word

    def startsWith(self, prefix: str) -> bool:
        current = self.root
        for i in prefix:
            idx = ord(i) - ord('a')
            if current.node[idx] is None:
                return False 
            current = current.node[idx]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)