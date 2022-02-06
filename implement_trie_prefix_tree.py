# TC : 
# SC : (NK)
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.child = [None]*26
        

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for char in word:
            if node.child[ord(char) - ord('a')] == None:
                node.child[ord(char) - ord('a')] = TrieNode()
            node = node.child[ord(char) - ord('a')]
        node.isEnd = True
                

    def search(self, word: str) -> bool:
        node = self.root
        for char in word:
            if node.child[ord(char) - ord('a')] == None:
                return False
            node = node.child[ord(char) - ord('a')]
        if node.isEnd:
            return True
        else:
            return False
            

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for char in prefix:
            if node.child[ord(char) - ord('a')] == None:
                return False
            node = node.child[ord(char) - ord('a')]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
