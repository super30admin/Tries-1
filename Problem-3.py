# Time Complexity : O(N*L + S)
# N = number of dictionary words, L = average root length, S = total sentence length
# Space Complexity : O(N*L)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Build a Trie from all dictionary root words so prefix lookups can be done efficiently.
# 2. For each word in the sentence, traverse the Trie to find the shortest root prefix.
# 3. If a root is found, replace the word with that prefix; otherwise keep the original word.

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

    def getRoot(self, word):
        node = self.root
        prefix = ""

        for ch in word:
            if ch not in node.children:
                return word
            node = node.children[ch]
            prefix += ch
            if node.isEnd:
                return prefix
        
        return word


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()

        # Insert dictionary roots into Trie
        for word in dictionary:
            trie.insert(word)

        words = sentence.split()

        # Replace each word with the shortest root prefix
        for i in range(len(words)):
            words[i] = trie.getRoot(words[i])

        return " ".join(words)