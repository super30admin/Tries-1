
class TrieNode:
    def __init__(self) -> None:
        self.children = [None]*26
        self.is_end = False

class Trie:

    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word: str) -> None:
        ## T.C = O(n)
        curr = self.root
        for i in range(len(word)):
            idx = ord(word[i]) - ord('a')
            if curr.children[idx] == None:
                curr.children[idx] = TrieNode()
            curr = curr.children[idx]
        curr.is_end = True

    def search(self, word: str) -> bool:
        ## T.C = O(n)
        curr = self.root
        for i in range(len(word)):
            idx = ord(word[i]) - ord('a')
            if curr.children[idx] == None:
                return False
            curr = curr.children[idx]
        return curr.is_end

    def startsWith(self, prefix: str) -> bool:
        ## T.C = O(n)
        curr = self.root
        for i in range(len(prefix)):
            idx = ord(prefix[i]) - ord('a')
            if curr.children[idx] == None:
                return False
            curr = curr.children[idx]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)