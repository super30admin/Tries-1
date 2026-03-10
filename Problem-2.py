# Time Complexity : O(N * L)  # N = number of words, L = average word length
# Space Complexity : O(N * L) # Space used by Trie
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Build a Trie containing all words so prefix lookups can be done efficiently.
# 2. For each word, check whether all prefixes of that word exist in the Trie.
# 3. Since words are sorted lexicographically, the longest valid word whose prefixes exist is returned.

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for ch in word:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            node = node.children[ch]
        node.isEnd = True

    def search(self, word):
        node = self.root
        for ch in word:
            if ch not in node.children:
                return False
            node = node.children[ch]
        return node.isEnd


class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()

        # Insert all words into Trie
        for word in words:
            trie.insert(word)

        # Sort words to handle lexicographical order
        words.sort()
        longest = ""

        for word in words:
            valid = True

            # Check if all prefixes exist
            for i in range(1, len(word)):
                if not trie.search(word[:i]):
                    valid = False
                    break

            # Update longest valid word
            if valid and len(word) > len(longest):
                longest = word

        return longest