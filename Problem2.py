"""
## Problem 2

Replace Words (https://leetcode.com/problems/replace-words/)
"""

from typing import List

class Solution:
    """
    Replaces words in a sentence with their corresponding shortest root from a given dictionary.
    Each word in the sentence is replaced only if a root word exists that is a prefix of it.

    Approach:
    - Convert the dictionary list to a set for O(1) average-time prefix checks.
    - Split the sentence into individual words.
    - For each word, scan all prefixes from shortest to longest and replace it with the shortest matching root word if found.
    - Reconstruct and return the updated sentence.

    This approach avoids using a Trie for simplicity but still maintains acceptable performance for moderate inputs.
    """

    # ========================= Set-Based Prefix Matching =========================
    # TC: O(n * l^2)
    #   - n = number of words in the sentence
    #   - l = average length of each word (due to checking all prefixes)
    #
    # SC: O(m  + n)
    #   - m = number of root words in the dictionary
    #   - k = average length of each root word
    #   - n = number of words in the sentence
    #   - l = average length of each word in the sentence
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        dict_set = set(dictionary)  # O(m * k) space
        words = sentence.split()    # O(n * l) space
        result = []

        for word in words:
            prefix_found = False
            for i in range(1, len(word) + 1):
                if word[:i] in dict_set:
                    result.append(word[:i])
                    prefix_found = True
                    break
            if not prefix_found:
                result.append(word)

        return " ".join(result)


"""
## Problem 4

Replace Words (https://leetcode.com/problems/replace-words/)

Approach:
- Use a Trie to store all root words from the dictionary.
- For each word in the sentence, search the Trie to find the shortest root that is a prefix.
- Replace the word with the found root, or keep it unchanged if no root matches.

This ensures efficient prefix matching and optimal sentence transformation.
"""

from typing import List

# ========================= Trie Node =========================
class TrieNode:
    def __init__(self):
        self.children = [None] * 26  # For 'a' to 'z'
        self.is_end = False          # Marks end of a valid root word

# ========================= Solution Class =========================
class Solution:
    # TC: O(N * L + S * W)
    #   - N = number of dictionary words
    #   - L = avg length of each dictionary word
    #   - S = number of words in sentence
    #   - W = avg length of each word in the sentence
    #
    # SC: O(N * L) - space used by the Trie to store root words

    def __init__(self):
        self.root = TrieNode()

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        # Insert all root words into the Trie
        for word in dictionary:
            self._insert(word)

        # Replace each word in the sentence with its root
        replaced_words = [self._search_root(word) for word in sentence.split()]
        return " ".join(replaced_words)

    def _insert(self, word: str):
        node = self.root
        for char in word:
            idx = ord(char) - ord('a')
            if not node.children[idx]:
                node.children[idx] = TrieNode()
            node = node.children[idx]
        node.is_end = True

    def _search_root(self, word: str) -> str:
        node = self.root
        prefix = ""

        for char in word:
            idx = ord(char) - ord('a')
            if not node.children[idx]:
                return word  # No matching prefix
            node = node.children[idx]
            prefix += char
            if node.is_end:
                return prefix  # Found the shortest root

        return word  # No root found, return original word
