# Problem 3 : Replace Words
# Time Complexity : O(n * L + k * L)
'''
n- number of words in dictionary
L- average length of the word in the sentence
k- number of word in sentence
'''
# Space Complexity : O(n * L + k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
import string
from typing import List
class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: string) -> None:
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.isEnd = True

    
    def replaceShortWord(self, word: string) -> string:
        node = self.root
        root = ""
        for char in word:
            if char in node.children:
                root += char
                node = node.children[char]
                if node.isEnd:
                    return root
            else:
                return word
        return word

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:
            trie.insert(word)
        words = sentence.split()
        resultSentence = []
        for word in words:
            resultSentence.append(trie.replaceShortWord(word))
        return " ".join(resultSentence)
