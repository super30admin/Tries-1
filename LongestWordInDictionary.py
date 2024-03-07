'''
TC: O(n) where n is all the words given to build Trie 
        and check for the longest
SC: O(h) h being the height of the tree
'''
from typing import List

class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.flag = False
class Solution:
    def longestWord(self, words: List[str]) -> str:
        self.head = TrieNode()
        self.resWord = ""

        def insertTrie(word):
            pointer = self.head
            for letter in word:
                order = ord(letter)-ord('a')
                if pointer.children[order]==None:
                    pointer.children[order] = TrieNode()
                pointer = pointer.children[order]
            pointer.flag = True

        for word in words:
            insertTrie(word)
        pointer = self.head

        def dfs(root, word):
            if not root:
                return
            if len(word) > len(self.resWord):
                self.resWord = word 
            for i, element in enumerate(root.children):
                if element and element.flag:
                    word += chr(i+ord('a'))
                    dfs(element, word)
                    word = word[:-1]
            
        dfs(pointer, "")
        return self.resWord
s = Solution()
print(s.longestWord(["w","wo","wor","worl","world"]))
print(s.longestWord(["a","banana","app","appl","ap","apply","apple"]))
print(s.longestWord(["m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"]))