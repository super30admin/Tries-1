# Problem 2 : Longest Word in Dictionary
# Time Complexity : O(n*L) where n is the number of words and L is the average length of the word
# Space Complexity : O(n*L) where n is the number of words and L is the average length of the word
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class TrieNode:
    def __init__(self):
        # dictionary for children which will store all possible 26 characters
        self.children = {}
        # boolean variable to end that this is last character of the word
        self.isEnd = False

class Trie:

    def __init__(self):
        # initializing the Trie Node
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        # get a node pointing to root
        node = self.root
        # loop through word
        for char in word:
            # check if the character is not present in the node.children
            if char not in node.children:
                # initialize the node.children[char] with Trie Node
                node.children[char] = TrieNode()
            # increment the node to next node ie. node.children[char]
            node = node.children[char]
        # set the isEnd variable to true for last character
        node.isEnd = True

    def checkValidWord(self, word: str) -> bool:
        # get a node pointing to root
        node = self.root
        # loop through word
        for char in word:
            # check if character is not present in node.children
            if char not in node.children:
                # return False
                return False
            # increment the node to next node ie. node.children[char]
            node = node.children[char]
            # this check is used for prefix check 
            # if the node is not the end of the word, the word is not valid
            if not node.isEnd:
                return False
        
        # return true since word exists and is valid 
        return True

class Solution:
    def longestWord(self, words: List[str]) -> str:
        # create trie instance
        trie = Trie()
        # insert each word of words list in trie
        for word in words:
            trie.insert(word)
        # initialize the answer variable to store the longest word
        answer = ""
        # iterate over each word
        for word in words:
            # search if the word is valid first then 
            # check the length of the answer and current word, if the current word is longer than answer then update the answer 
            # or if the length is equal then get lexicographically smaller between answer and word
            if trie.checkValidWord(word) and (len(answer) < len(word) or (len(answer) == len(word) and answer > word)):
                answer = word
        
        return answer