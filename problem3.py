# https://leetcode.com/problems/replace-words/

# Time Complexity : O(N) where N is length of the input string.
# Space Complexity : O(N) is length of the input string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, Fixed it later.


# Your code here along with comments explaining your approach

# Approach : We keep adding all the words to the trie. Whenever while adding a word if we IsEnd as true, we
# will stop processing it. [This is an optimization]
# After we that we again search for the words we added and return the shortest isEnd substring and replace it
# with the original word. # We can do this with hashing.


from typing import List


class TrieNode:
    isEnd: bool
    children: []
    word: str

    def __init__(self):
        self.isEnd = False
        word = ""
        self.children = [None] * 26


class Trie:
    root: TrieNode

    def __init__(self):
        self.root = TrieNode()

    def add(self, word):
        cur = self.root
        for char in word:
            index = ord(char) - 97
            if cur.children[index] is None:
                cur.children[index] = TrieNode()
            cur = cur.children[index]
        cur.isEnd = True
        cur.word = word

    def findMatch(self, word):
        cur = self.root
        for char in word:
            index = ord(char) - 97
            if cur.children[index] is not None:
                cur = cur.children[index]
                if cur.isEnd:
                    return cur.word
            else:
                return word
        return word


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        _trie = Trie()
        for word in dictionary:
            _trie.add(word)

        words = sentence.split(' ')
        result = []
        for word in words:
            result.append(_trie.findMatch(word))

        return " ".join(result)
