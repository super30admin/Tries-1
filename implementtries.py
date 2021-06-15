# Space:- 26^m
# time :- O(n)
k
class Trie:
    class TrieNode:
        def __init__(self):
            self.isend = False
            self.children = [None for _ in range(26)]

    def __init__(self):
        self.root = self.TrieNode()
        """
        Initialize your data structure here.
        """

    def insert(self, word: str) -> None:
        ptr = self.root
        for character in word:

            if ptr.children[ord(character) - ord('a')] == None:
                ptr.children[ord(character) - ord('a')] = self.TrieNode()
            ptr = ptr.children[ord(character) - ord('a')]
        ptr.isend = True

        """
        Inserts a word into the trie.
        """

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        ptr = self.root
        for character in word:
            if ptr.children[ord(character) - ord('a')] == None: return False
            ptr = ptr.children[ord(character) - ord('a')]
        return ptr.isend

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        ptr = self.root
        for character in prefix:
            if ptr.children[ord(character) - ord('a')] == None: return False
            ptr = ptr.children[ord(character) - ord('a')]
        return True

    # Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
