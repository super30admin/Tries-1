"""
Rasika Sasturkar
Time Complexity: O(L) for all operations, where L is length of the word.
Space Complexity: O(1)
"""


class TrieNode:
    """
    Constructing a Trie Node
    """

    def __init__(self):
        self.is_end = False
        self.children = [None for _ in range(26)]


class Trie:
    """
    implementing insert operation, searching a word in Trie, and
    searching a prefix in Trie.
    """

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            char = word[i]
            if curr.children[ord(char) - ord('a')] is None:
                curr.children[ord(char) - ord('a')] = TrieNode()
            curr = curr.children[ord(char) - ord('a')]
        curr.is_end = True

    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(len(word)):
            char = word[i]
            if curr.children[ord(char) - ord('a')] is None:
                return False
            curr = curr.children[ord(char) - ord('a')]
        return curr.is_end

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(len(prefix)):
            char = prefix[i]
            if curr.children[ord(char) - ord('a')] is None:
                return False
            curr = curr.children[ord(char) - ord('a')]
        return True


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    trie = Trie()
    trie.insert("apple")
    print(trie.search("apple"))  # return True
    print(trie.search("app"))  # return False
    print(trie.startsWith("app"))  # return True
    trie.insert("app")
    print(trie.search("app"))  # return True


if __name__ == "__main__":
    main()
