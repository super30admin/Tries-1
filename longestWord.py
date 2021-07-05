# Time Complexity : O(L)
# Space Complexity : O(L)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for i in range(26)]
        self.index = -1

class Solution:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        self.longest_word = ""
        return

    def insert(self, word: str, index:int) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c) - ord('a')] is None:
                curr.children[ord(c)-ord('a')] = TrieNode() 
            curr = curr.children[ord(c)-ord('a')]

        curr.isEnd = True

        curr.index = index


    def longestWord(self, words: List[str]) -> str:

        for index, word in enumerate(words):
            self.insert(word, index)

        stack = [child for child in self.root.children if child is not None]
        while len(stack) > 0:
            curr = stack.pop()
            if curr.isEnd:
                word = words[curr.index]
                if self.longest_word == "" or \
                        len(word) > len(self.longest_word) or \
                        (len(word) == len(self.longest_word) and word < self.longest_word):
                    self.longest_word = word

                for child in curr.children:
                    if child is not None:
                        stack.append(child)

        return self.longest_word 