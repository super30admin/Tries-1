"""
Problem: 720. Longest Word in Dictionary
Leetcode: https://leetcode.com/problems/longest-word-in-dictionary/
Time Complexity: O(∑w_i), where w_i is the length of words[i]. This is the complexity to build the trie and to search it.
Space Complexity: O(∑w_i), the space used by our trie.
Does this code run on Leetcode: Yes
"""


class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.word = None  # Record the built word for the current node
        self.length = 0  # Record the continue length of the build word


class Trie:
    def __init__(self):
        self.root = TrieNode()
        self.max_length = -1  # the max length of the word in the entire words list
        self.word = None  # the resulting word

    def insert(self, word):
        current = self.root
        word_length = 1
        for letter in word:
            if current.word:
                word_length += 1
            else:
                # Reset length if one character is skipped
                word_length = 1
            current = current.children[letter]
        current.word = word
        current.length = word_length if word_length == len(word) else 1

        if current.length > self.max_length:
            self.max_length = current.length
            self.word = word
        elif current.length == self.max_length:
            self.word = min(word, self.word)


class Solution:
    def longestWord(self, words: List[str]) -> str:
        tree = Trie()
        [tree.insert(word) for word in sorted(words)]  # Have to sort to make sure the word is built in order

        return tree.word