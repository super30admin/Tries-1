class TrieNode:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.isEnd = False
        self.children = [None for i in range(26)]


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word: str) -> None:  # TC:O(L)
        # SC:O(L)
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            if curr.children[ord(ch) - ord('a')] == None:
                curr.children[ord(ch) - ord('a')] = TrieNode()
            curr = curr.children[ord(ch) - ord('a')]

        curr.isEnd = True

    def search(self, word: str) -> bool:  # TC:O(L)
        # SC:O(1)
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            if curr.children[ord(ch) - ord('a')] == None:
                return False
            curr = curr.children[ord(ch) - ord('a')]

        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:  # TC:O(P)
        # SC:O(1)
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for i in range(len(prefix)):
            ch = prefix[i]
            if curr.children[ord(ch) - ord('a')] == None:
                return False
            curr = curr.children[ord(ch) - ord('a')]

        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)