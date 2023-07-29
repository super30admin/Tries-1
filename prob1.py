# Time Complexity : insert O(l), search O(1)
# Space Complexity :O(n)
# Passed on Leetcode: yes

class TrieNode:
    def __init__(self):
        self.flag = False
        self.trie_arr = [None for _ in range(26)]

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for char in word:
            idx = ord(char) - ord('a')
            if not node.trie_arr[idx]:
                node.trie_arr[idx] = TrieNode()
            node = node.trie_arr[idx]
        node.flag = True

    def search(self, word: str) -> bool:
        node = self.root
        for char in word:
            idx = ord(char) - ord('a')
            if not node.trie_arr[idx]:
                return False
            node = node.trie_arr[idx]
        return node.flag

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for char in prefix:
            idx = ord(char) - ord('a')
            if not node.trie_arr[idx]:
                return False
            node = node.trie_arr[idx]
        return True
