# // Time Complexity : O(n)
# // Space Complexity : O(k) where k is sum of words
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : Followed approach from class
# implementaion of Trie
class TrieNode:
    def __init__(self, char):
        self.char = char
        self.children = [None] * 26
        self.isWord = False
class Trie:

    def __init__(self):
        self.trie = TrieNode('0')

    def insert(self, word: str) -> None:
        t = self.trie
        for char in word:
            childIdx = ord(char) - ord('a')
            if not t.children[childIdx]:
                newNode = TrieNode(char)
                t.children[childIdx] = newNode

            t = t.children[childIdx]
        t.isWord = True

    def search(self, word: str) -> bool:
        t = self.trie
        for char in word:
            childIdx = ord(char) - ord('a')
            if not t.children[childIdx]:
                return False
            t = t.children[childIdx]

        return t.isWord


    def startsWith(self, prefix: str) -> bool:
        t = self.trie
        for char in prefix:
            childIdx = ord(char) - ord('a')
            if not t.children[childIdx]:
                return False
            t = t.children[childIdx]

        return True 