# Intuition:
# We are asked to implement a data structure that supports three operations efficiently:
# - insert(word)
# - search(word)
# - startsWith(prefix)
#
# A naive idea is to use a set to store all inserted words and check for matches.
# A better idea is to use a hash map (dictionary) at each level to map characters to nodes.
# The most optimal solution for lowercase 'a' to 'z' uses an array of size 26 at each node,
# giving constant-time access for each character and predictable space usage.

# ----------------------------------------------------
# Time Complexity:
# - insert(word):     O(L)
# - search(word):     O(L)
# - startsWith(pref): O(L)
# where L = length of the word or prefix
#
# Space Complexity:
# - O(26 * N) where N = total number of Trie nodes
# - Each node uses O(1) space: fixed 26-size array
# ----------------------------------------------------

class TrieNode:
    def __init__(self):
        self.children = [None] * 26  # array for 'a' to 'z'
        self.endOfWord = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for ch in word:
            idx = ord(ch) - ord('a')
            if not curr.children[idx]:
                curr.children[idx] = TrieNode()
            curr = curr.children[idx]
        curr.endOfWord = True

    def search(self, word: str) -> bool:
        curr = self.root
        for ch in word:
            idx = ord(ch) - ord('a')
            if not curr.children[idx]:
                return False
            curr = curr.children[idx]
        return curr.endOfWord

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for ch in prefix:
            idx = ord(ch) - ord('a')
            if not curr.children[idx]:
                return False
            curr = curr.children[idx]
        return True


# HashMap-Based Trie (for larger or flexible alphabets)
#
# Time Complexity: O(L) per operation, where L is the length of the word or prefix
#
# Space Complexity: O(k * N)
# - N = total number of nodes in the Trie
# - k = branching factor → this means the number of different characters each node points to (its children)
#   In simple words, it's how many "next letter" options exist from a node.
#   For example, if a node has paths for 'a', 'b', and 'c', then its branching factor is 3.

# class TrieNode:
#     def __init__(self):
#         self.children = {}
#         self.endOfWord = False
#
# class Trie:
#     def __init__(self):
#         self.root = TrieNode()
#
#     def insert(self, word: str) -> None:
#         curr = self.root
#         for ch in word:
#             if ch not in curr.children:
#                 curr.children[ch] = TrieNode()
#             curr = curr.children[ch]
#         curr.endOfWord = True
#
#     def search(self, word: str) -> bool:
#         curr = self.root
#         for ch in word:
#             if ch not in curr.children:
#                 return False
#             curr = curr.children[ch]
#         return curr.endOfWord
#
#     def startsWith(self, prefix: str) -> bool:
#         curr = self.root
#         for ch in prefix:
#             if ch not in curr.children:
#                 return False
#             curr = curr.children[ch]
#         return True


# ------------------------------------------------------
# Brute Force using Set (Naive Implementation)
#
# Time Complexity:
# - insert:     O(1)
# - search:     O(1)
# - startsWith: O(N * L) where N = number of words, L = avg word length
#
# Space Complexity: O(N * L)
#
# Intuition:
# - Store all words in a set
# - Use string startswith() to check prefixes (linear scan through all stored words)

# class Trie:
#     def __init__(self):
#         self.words = set()
#
#     def insert(self, word: str) -> None:
#         self.words.add(word)
#
#     def search(self, word: str) -> bool:
#         return word in self.words
#
#     def startsWith(self, prefix: str) -> bool:
#         for word in self.words:
#             if word.startswith(prefix):
#                 return True
#         return False


if __name__ == "__main__":
    trie = Trie()
    trie.insert("apple")
    print(trie.search("apple"))     # True
    print(trie.search("app"))       # False
    print(trie.startsWith("app"))   # True
    trie.insert("bottle")
    print(trie.search("bot"))       # False