"""
Rasika Sasturkar
Time Complexity: O(n*k), where n is no. of words of avg. length k
Space Complexity: O(k*26)
"""

from collections import deque


class TrieNode:
    """
    Constructing a Trie Node
    """

    def __init__(self):
        self.is_end = False
        self.children = [None for _ in range(26)]
        self.word = ""


class Solution:
    def __init__(self):
        self.root = None

    def insert(self, word: str) -> None:
        """
        Inserting into a Trie
        """
        curr = self.root
        for i in range(len(word)):
            char = word[i]
            if curr.children[ord(char) - ord('a')] is None:
                curr.children[ord(char) - ord('a')] = TrieNode()
            curr = curr.children[ord(char) - ord('a')]
        curr.is_end = True
        curr.word = word

    def longestWord(self, words) -> str:
        """
        Using BFS, we check if every letter of the word is in our dictionary
        of the words using a Trie. We find the word with the longest length and if
        there are 2 such words, we return the one with lexographically less value.
        """
        self.root = TrieNode()
        for word in words:
            self.insert(word)

        queue = deque([self.root])
        curr = self.root

        while queue:
            curr = queue.popleft()
            for i in range(25, -1, -1):
                if curr.children[i] is not None and curr.children[i].is_end:
                    queue.append(curr.children[i])
        return curr.word


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    s = Solution()
    print(s.longestWord(words=["w", "wo", "wor", "worl", "world"]))  # returns "world"
    print(s.longestWord(words=["a", "banana", "app", "appl", "ap", "apply", "apple"]))  # returns "apple"


if __name__ == "__main__":
    main()
