class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.endof = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:  # O(l)
        curr = self.root
        for c in word:
            i = ord(c) - ord("a")
            if curr.children[i] == None:
                curr.children[i] = TrieNode()
            curr = curr.children[i]
        curr.endof = True

    def search(self, word: str) -> bool:  # O(l)
        curr = self.root
        for c in word:
            i = ord(c) - ord("a")
            if curr.children[i] == None:
                return False
            curr = curr.children[i]
            # print(curr.children[i])

        return curr.endof

    def startsWith(self, prefix: str) -> bool:  # O(l)
        curr = self.root
        for c in prefix:
            i = ord(c) - ord("a")
            if curr.children[i] == None:
                return False
            curr = curr.children[i]
        return True


# space complexity is O(n*l)  where l is the average length of the words
# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
