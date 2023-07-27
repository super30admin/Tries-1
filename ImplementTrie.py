class TrieNode:
    def __init__(self):
        self.is_end = False
        self.children = [None] * 26

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for ch in word:
            index = ord(ch) - ord('a')
            if curr.children[index] == None:
                curr.children[index] = TrieNode()
            curr = curr.children[index]
        curr.is_end = True

    def search(self, word) -> bool:
        curr = self.root
        for ch in word:
            index = ord(ch) - ord('a')
            if curr.children[index] == None:
                return False
            curr = curr.children[index]
        if curr.is_end == True:
            return True
        else:
            return False
        
    def startsWith(self, prefix) -> bool:
        curr = self.root
        for ch in prefix:
            index = ord(ch) - ord('a')
            if curr.children[index] == None:
                return False
            curr = curr.children[index]
        return True








