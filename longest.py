# The longestWord method finds the longest word in a list that can be built one letter at a time using other words in the list.

# A Trie is used to efficiently store the words and check if each prefix is valid.
# Insert each word into the Trie and mark the end of valid words.

# For each word, traverse the Trie to verify all prefixes exist.
# Update the result if the word is longer than the current result or lexicographically smaller when lengths are equal.

# TC: O(n * m) - n is the number of words, m is the average word length.
# SC: O(n * m) - Space for the Trie structure.


from typing import List


class TrieNode(object):
    def __init__(self):
        self.children = {}
        self.end = False

class Solution:
    def longestWord(self, words: List[str]) -> str:
        root = TrieNode()
        for word in words:
            cur = root
            for letter in word:
                if letter not in cur.children:
                    cur.children[letter] = TrieNode()
                cur = cur.children[letter]
            cur.end = True
        
        res = ''
        for word in words:
            if len(word) < len(res): 
                continue
            cur = root
            for letter in word:
                cur = cur.children[letter]
                if not cur.end: 
                    break
            if cur.end and (len(word) > len(res) or (len(word) == len(res) and word < res)):
                res = word        
        return res
