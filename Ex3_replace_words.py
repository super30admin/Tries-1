# ----------------------------------------------------
# Intuition:
# We're given a dictionary of **root words** and a **sentence** made up of words.
# Our goal is to replace each word in the sentence with the shortest possible root from the dictionary,
# but only if that root is a prefix of the word.
#
# Brute-Force Approach:
# - For every word in the sentence, we check all root words to see if any is a prefix.
# - Among those that are prefixes, we choose the shortest one.
# - This leads to a time complexity of O(W × R × L), where:
#   W = number of words in sentence, R = number of roots, L = word/root length.
#
# Set-Based Prefix Scan:
# - First, store all roots in a set for O(1) lookup.
# - For each word in the sentence, we check all its prefixes one character at a time.
# - As soon as we find a prefix that exists in the set, we replace the word.
# - This reduces complexity and avoids checking every dictionary word for every sentence word.
#
# Trie-Based (Optimal):
# - We build a Trie with all root words. Each path in the Trie represents a potential prefix.
# - While processing a word from the sentence, we walk character-by-character down the Trie.
# - As soon as we reach a node that marks the end of a root, we stop and use that prefix.
# - This is efficient because both insertion and search operations in a Trie take O(L) time,
#   and we avoid unnecessary comparisons and lookups.
# ----------------------------------------------------

# ----------------------------------------------------
# Time Complexity: O(D × L + W × L)
# - D = number of dictionary words
# - W = number of words in the sentence
# - L = average length of each word/root
# - O(D × L): Building the Trie
# - O(W × L): Replacing each sentence word by scanning the Trie up to L characters
#
# Space Complexity: O(D × L)
# - Trie stores all root words character by character
# - Output sentence is reused, no extra structure
# ----------------------------------------------------

from typing import List

class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end = False  # Marks the end of a root word

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        # Build Trie
        root = TrieNode()
        for word in dictionary:
            node = root
            for ch in word:
                if ch not in node.children:
                    node.children[ch] = TrieNode()
                node = node.children[ch]
            node.is_end = True

        def find_root(word: str) -> str:
            node = root
            prefix = []
            for ch in word:
                if ch not in node.children:
                    break
                prefix.append(ch)
                node = node.children[ch]
                if node.is_end:
                    return ''.join(prefix)
            return word  # No root matched

        words = sentence.split()
        replaced = [find_root(word) for word in words]
        return ' '.join(replaced)

# ----------------------------------------------------
# Set-Based Prefix Scan Approach
#
# Time Complexity: O(D × L + W × L)
# - O(D × L): Creating set of roots
# - O(W × L): For each word, check all prefixes up to length L
#
# Space Complexity: O(D × L)
# - Set stores all dictionary words
#
#         def replaceWords(self, dictionary: List[str], sentence: str) -> str:
#             root_set = set(dictionary)
#             words = sentence.split()
#             for i in range(len(words)):
#                 for j in range(1, len(words[i]) + 1):
#                     if words[i][:j] in root_set:
#                         words[i] = words[i][:j]
#                         break
#             return ' '.join(words)

# ----------------------------------------------------
# Brute Force Approach
#
# Time Complexity: O(W × R × L)
# - W = number of sentence words
# - R = number of dictionary roots
# - L = average word/root length
#
# Space Complexity: O(1) extra (ignoring output)
#
#         def replaceWords(self, dictionary: List[str], sentence: str) -> str:
#             words = sentence.split()
#             for i in range(len(words)):
#                 shortest = words[i]
#                 for root in dictionary:
#                     if words[i].startswith(root):
#                         if len(root) < len(shortest):
#                             shortest = root
#                 words[i] = shortest
#             return ' '.join(words)

# ----------------------------------------------------

if __name__ == "__main__":
    sol = Solution()

    # Test Case 1
    dictionary1 = ["cat", "bat", "rat"]
    sentence1 = "the cattle was rattled by the battery"
    print(sol.replaceWords(dictionary1, sentence1))  # Expected: "the cat was rat by the bat"

    # Test Case 2
    dictionary2 = ["a", "b", "c"]
    sentence2 = "aadsfasf absbs bbab cadsfafs"
    print(sol.replaceWords(dictionary2, sentence2))  # Expected: "a a b c"

    # Test Case 3
    dictionary3 = ["help", "base"]
    sentence3 = "helpful helpless baseball"
    print(sol.replaceWords(dictionary3, sentence3))  # Expected: "help help base"

    # Test Case 4: No replacements
    dictionary4 = ["xyz"]
    sentence4 = "the quick brown fox"
    print(sol.replaceWords(dictionary4, sentence4))  # Expected: "the quick brown fox"

    # Test Case 5: Overlapping roots, prefer shortest
    dictionary5 = ["a", "aa", "aaa"]
    sentence5 = "aaaaa aaaa aa a"
    print(sol.replaceWords(dictionary5, sentence5))  # Expected: "a a a a"
