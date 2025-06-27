Time complexity is O(m) 
Space complexity is O(n*m)

from typing import Dict

class TrieNode:
    def __init__(self, c: str):
        self.c = c
        self.childset: Dict[str, 'TrieNode'] = {}
        self.isWord = False


class Trie:
    def __init__(self):
        self.root = TrieNode('\0')

    def insert(self, word: str) -> None:
        if not word:
            return
        current = self.root
        for char in word:
            if char not in current.childset:
                current.childset[char] = TrieNode(char)
            current = current.childset[char]
        current.isWord = True

    def search(self, word: str) -> bool:
        node = self.get_word_node(word)
        return node is not None and node.isWord

    def startsWith(self, prefix: str) -> bool:
        return self.get_word_node(prefix) is not None

    def get_word_node(self, word: str) -> TrieNode:
        if not word:
            return None
        current = self.root
        for char in word:
            if char not in current.childset:
                return None
            current = current.childset[char]
        return current
