# Time Complexity: O(n)
# Space Complexity: O(n)
# Ran on Leetcode: Yes

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for char in word:
            if not curr.children[ord(char) - 97]:
                curr.children[ord(char) - 97] = TrieNode()
            curr = curr.children[ord(char) - 97]
        curr.isEnd = True
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for char in word:
            if not curr.children[ord(char) - 97]:
                return False
            curr = curr.children[ord(char) - 97]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for char in prefix:
            if not curr.children[ord(char) - 97]:
                return False
            curr = curr.children[ord(char) - 97]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)