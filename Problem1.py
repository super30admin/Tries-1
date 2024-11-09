class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for _ in range(26)]


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:  # TC = O(l)  |  SC =O(26 * l) = O(l)
        curr = self.root
        for i in range(len(word)):  # c - 'b'
            c = ord(word[i])
            if curr.children[c - ord('a')] == None:
                curr.children[c - ord('a')] = TrieNode()
            curr = curr.children[c - ord('a')]
        curr.isEnd = True

    def search(self, word: str) -> bool:  #O(l)
        curr = self.root
        for i in range(len(word)):  # c - 'b'
            c = ord(word[i])
            if curr.children[c - ord('a')] == None:
                return False
            curr = curr.children[c - ord('a')]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:  # O(l)
        curr = self.root
        for i in range(len(prefix)):  # c - 'b'
            c = ord(prefix[i])
            if curr.children[c - ord('a')] == None:
                return False
            curr = curr.children[c - ord('a')]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)