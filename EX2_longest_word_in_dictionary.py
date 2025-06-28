# ----------------------------------------------------
# Intuition:
# We want to find the longest word in the list such that every prefix of that word
# is also present in the list (i.e., the word can be built one character at a time).
#
# 1. Brute Force (Naive):
#    - Put all words into a set for O(1) prefix lookups.
#    - For each word, check if all its prefixes (word[:1], word[:2], ..., word[:-1]) exist in the set.
#    - This involves checking each prefix substring for every word, which can be costly.
#
# 2. Slightly Optimal (Sort + Set):
#    - Sort the words lexicographically to handle tie-breaking by lex order automatically.
#    - Maintain a set of valid words starting with the empty string "".
#    - For each word, check if its prefix (word[:-1]) is in the valid set.
#      If yes, add this word to the set and update the longest word accordingly.
#
# 3. Optimal (Trie + DFS):
#    - Build a Trie (prefix tree) with all words.
#    - Store the full word at terminal nodes.
#    - Use DFS to traverse only nodes representing valid words.
#    - Sort children during traversal to maintain lex order and find the longest valid word.
#    - This avoids repeated prefix checks and enables efficient prefix validation.
# ----------------------------------------------------

# ----------------------------------------------------
# Time and Space Complexities
#
# 1. Brute Force (Naive):
#    Time: O(N * L^2)
#    - N words, L average length
#    - For each word, check L prefixes; each prefix check is O(L) for slicing (could be O(1) with indexing)
#    Space: O(N * L) for the set storing all words
#
# 2. Sort + Set:
#    Time: O(N log N + N * L)
#    - Sorting takes O(N log N)
#    - Iterating and prefix checks take O(N * L)
#    Space: O(N * L) for the set storing valid words
#
# 3. Trie + DFS:
#    Time: O(N * L + M log M)
#    - N words, L avg length to build trie
#    - M total nodes in trie for DFS sorting children
#    Space: O(N * L) for trie storage
# ----------------------------------------------------
from typing import List


class TrieNode:
    def __init__(self):
        self.children = {}
        self.word = None  # Store full word at terminal node

class Solution:
    def longestWord(self, words: List[str]) -> str:
        # Build Trie
        root = TrieNode()
        for word in words:
            node = root
            for ch in word:
                if ch not in node.children:
                    node.children[ch] = TrieNode()
                node = node.children[ch]
            node.word = word  # Mark terminal node with word

        # DFS traversal with stack
        stack = []
        for ch in sorted(root.children.keys(), reverse=True):
            child = root.children[ch]
            if child.word:
                stack.append(child)

        longest = ""
        while stack:
            node = stack.pop()
            if node.word is not None:
                # Update longest if longer or lex smaller when tie
                if len(node.word) > len(longest) or (len(node.word) == len(longest) and node.word < longest):
                    longest = node.word
                # Push children that are valid words
                for ch in sorted(node.children.keys(), reverse=True):
                    child = node.children[ch]
                    if child.word:
                        stack.append(child)

        return longest

# ----------------------------------------------------
# # Slightly Optimal Sort + Set Approach
# class Solution:
#     def longestWord(self, words: List[str]) -> str:
#         words.sort()
#         valid = set([""])
#         longest = ""
#         for word in words:
#             if word[:-1] in valid:
#                 valid.add(word)
#                 if len(word) > len(longest):
#                     longest = word
#         return longest

# ----------------------------------------------------
# # Brute Force (Naive) Approach
# class Solution:
#     def longestWord(self, words: List[str]) -> str:
#         word_set = set(words)
#         longest = ""
#         for word in words:
#             isValid = True
#             for i in range(1, len(word)):
#                 if word[:i] not in word_set:
#                     isValid = False
#                     break
#             if isValid:
#                 if len(word) > len(longest) or (len(word) == len(longest) and word < longest):
#                     longest = word
#         return longest


if __name__ == "__main__":
    sol = Solution()

    # Test Case 1: Example from prompt
    words1 = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
    print(sol.longestWord(words1))  # Expected: "apple"

    # Test Case 2: Words build up perfectly, lexicographically smaller chosen
    words2 = ["w", "wo", "wor", "worl", "world"]
    print(sol.longestWord(words2))  # Expected: "world"

    # Test Case 3: Multiple candidates same length, choose lex smaller
    words3 = ["a", "b", "ab", "abc", "abd"]
    print(sol.longestWord(words3))  # Expected: "abc"

    # Test Case 4: No word can be extended, only single letters — pick smallest lex
    words4 = ["z", "x", "q"]
    print(sol.longestWord(words4))  # Expected: "q"

    # Test Case 5: Empty list
    words5 = []
    print(sol.longestWord(words5))  # Expected: ""

    # Test Case 6: Words with valid full prefix chains — longest one should win
    words6 = ["a", "ab", "abc", "abd", "abde", "abdef"]
    print(sol.longestWord(words6))  # Expected: "abdef"

    # Test Case 7: Single word only
    words7 = ["hello"]
    print(sol.longestWord(words7))  # Expected: "hello"

    # Test Case 8: Words with repeated prefixes — choose longest, then lex smallest
    words8 = ["a", "ap", "app", "appl", "apple", "apply", "applz"]
    print(sol.longestWord(words8))  # Expected: "apple"

