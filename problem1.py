# time complexity : Insert, Search, startswith : O(n) where n is the length of the word
# Space complexity: o(m*n) where m is the number of word and n is the avg length of the word


class TrieNode:

    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False


class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root

        for c in word:
            if curr.children[ord(c) - ord("a")] is None:
                curr.children[ord(c) - ord("a")] = TrieNode()

            curr = curr.children[ord(c) - ord("a")]

        curr.isEnd = True

    def search(self, word: str) -> bool:
        curr = self.root

        for c in word:
            if curr.children[ord(c) - ord("a")] is None:
                return False

            curr = curr.children[ord(c) - ord("a")]

        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self.root

        for c in prefix:
            if curr.children[ord(c) - ord("a")] is None:
                return False

            curr = curr.children[ord(c) - ord("a")]

        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)