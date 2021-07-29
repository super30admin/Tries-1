# Time Complexity:
#     insert - O(n), where n - length of the word
#     search - O(n), where n - length of the word
#     startsWith - O(n), where n - length of the prefix
# Space Complexity: O(Nk), where N - number of words, k - average length of the words
# Did this code successfully run on Leetcode: Yes

# Solution:

class TrieNode:
    """
    A TrieNode has a variable is_end and a children of TrieNodes of size 26
    """
    def __init__(self):
        self.is_end = False
        self.children = [None for x in range(26)]


class Trie:
    def __init__(self):
        """
        Initialize the root node
        """
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for ch in word:
            # Traverse through the char nodes and if it does not exist already, create a new node
            if not curr.children[ord(ch) - ord('a')]:
                curr.children[ord(ch) - ord('a')] = TrieNode()
            curr = curr.children[ord(ch) - ord('a')]
            # Indicate the end of the word in the last char
        curr.is_end = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for ch in word:
            if not curr.children[ord(ch) - ord('a')]:
                return False
            curr = curr.children[ord(ch) - ord('a')]
        return curr.is_end

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for ch in prefix:
            if not curr.children[ord(ch) - ord('a')]:
                return False
            curr = curr.children[ord(ch) - ord('a')]
        return True
