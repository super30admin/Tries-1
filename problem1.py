# https://leetcode.com/problems/implement-trie-prefix-tree/

# Time Complexity : O(N) where N is length of the input string.
# Space Complexity : O(N) is length of the input string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, Fixed it later.


# Your code here along with comments explaining your approach

# Approach : We just implement TRIE data structure. We have a class TrieNode which has list of 26
# TrieNode pointers for all the lowercase characters and isEnd to check if it is the end of the string.
# Using this we can solve the problem.
# FYI we can solve it using hashing as well.

class TrieNode:
    isEnd: bool
    children: []

    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False


class Trie:
    root = None

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        cur = self.root
        for char in word:
            index = ord(char) - 97
            print(index)
            if cur.children[index] is None:
                cur.children[index] = TrieNode()
            cur = cur.children[index]
        cur.isEnd = True

    def search(self, word: str) -> bool:
        cur = self.root
        for char in word:
            index = ord(char) - 97
            if cur.children[index] is None:
                return False
            cur = cur.children[index]
        return cur.isEnd

    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        for char in prefix:
            index = ord(char) - 97
            if cur.children[index] is None:
                return False
            cur = cur.children[index]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
