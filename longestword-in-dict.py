

from collections import defaultdict
from typing import List

# we first insert all the words to the Trie. Then, we go through the words again and look for the longest word in the dictionary using DFS.


class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.isWord = False

# as soon as we see that any word leading up to a word doesn't exist in the Trie we can stop searching deeper.


class Trie:
    def __init__(self):
        self.root = TrieNode()
        self.ret = ""

    def insert(self, word):
        node = self.root
        for letter in word:
            node = node.children[letter]
        node.isWord = True


class Solution:
    def longestWord(self, words: List[str]) -> str:
        def dfs(node, path):
            if not node.isWord:
                return
            if len(path) > len(self.ret):
                self.ret = "".join(path)
            for letter in node.children:
                dfs(node.children[letter], path+[letter])

# since we sort the words beforehand we have the longest word with the smallest lexicographical order.

        words.sort()
        trie = Trie()
        trie.root.isWord = True
        for word in words:
            trie.insert(word)
        self.ret = ""
        dfs(trie.root, [])
        return self.ret
