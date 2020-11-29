"""
Time Complexity : O(l) where l is length of the word
Space Complexity : O(l) where l is length of the word
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
For implementing Tries, a Trienode consists of children which I am making a dictionary and an isend node
which is False by default. For inserting, I traverse through the root and keep on checking if a path has a particular
node, if not we add that as a trienode in the dictionary and proceed further. After we reach end of the word,
we put it as True. Similarly with search and check prefix
"""


class TrieNode:
    def __init__(self):
        self.children = {}
        self.isend = False


class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for w in word:
            if w not in node.children:
                node.children[w] = TrieNode()
            node = node.children[w]
        node.isend = True

    def search(self, word: str) -> bool:
        node = self.root
        for w in word:
            if w not in node.children:
                return False
            node = node.children[w]
        return node.isend

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for w in prefix:
            if w not in node.children:
                return False
            node = node.children[w]
        return True
