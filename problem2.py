#Time Complexity : O(nlogn)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : yes
from ast import List

class Solution:
    def longestWord(self, words: List[str]) -> str:
        words.sort()
        longest_word = set()
        max_len = 0
        result = ""

        for w in words:
            if len(w) == 1 or w[:-1] in longest_word: 
                longest_word.add(w)
                if len(w) > max_len:
                    max_len = len(w)
                    result = w

        return result
    

# Using Trie#
#class Node:
#    def __init__(self):
#        self.node = [None] * 26
#        self.flag = False

#    def set_end(self):
#        self.flag = True

#class Trie:
#    def __init__(self):
#        self.root = Node()

#    def insert(self, word: str) -> None:
#        node = self.root
#        for char in word:
#            index = ord(char) - ord('a')
#            if not node.node[index]:
#                node.node[index] = Node()
#            node = node.node[index]
#        node.set_end()

#    def search(self, word: str) -> bool:
#        node = self.root
#        for char in word:
#            index = ord(char) - ord('a')
#            if not node.node[index]:
#                return False
#            node = node.node[index]
#        return node.flag

#class Solution:
#    def longestWord(self, words: List[str]) -> str:
#        trie = Trie()
#        for word in words:
#            trie.insert(word)

#        longest_word = ""
#        max_len = 0

#        def dfs(node, path):
#            nonlocal longest_word, max_len
#            if len(path) > max_len:
#                longest_word = path
#                max_len = len(path)

#            for i, child_node in enumerate(node.node):
#                if child_node and child_node.flag:
#                    dfs(child_node, path + chr(i + ord('a')))

#        dfs(trie.root, "")
#        return longest_word