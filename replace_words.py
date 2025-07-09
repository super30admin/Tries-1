# Time Complexity : O(n * k), where n is the number of words in the sentence and k is the max length of a word
# Space Complexity : O(total characters in all dictionary roots), for building the Trie
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used a Trie to efficiently find the shortest root that can replace a word.
# I first inserted all dictionary roots into the Trie.
# Then for each word in the sentence, I searched the Trie for the shortest prefix that matched.
# If a match was found, I used that root; otherwise, I kept the original word.

from typing import List

class TrieNode:
    def __init__(self):
        self.children = {}
        self.end = False

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        root = TrieNode()

        # Insert roots into the Trie
        for word in dictionary:
            node = root
            for char in word:
                if char not in node.children:
                    node.children[char] = TrieNode()
                node = node.children[char]
            node.end = True

        def find_root(word):
            node = root
            prefix = ""
            for char in word:
                if char not in node.children:
                    break
                node = node.children[char]
                prefix += char
                if node.end:
                    return prefix
            return word

        words = sentence.split()
        replaced = [find_root(word) for word in words]
        return " ".join(replaced)
