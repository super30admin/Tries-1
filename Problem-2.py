#Approach
#Create a trie node and loop through the character in the string. Every trie has a flag which tells the end of string.


#Complexities
#Time : O(N*L)
#Space : O(1)


from typing import List


class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26


class Solution:

    def checkLongestString(self, word):
        temp = self.root
        flag = 0
        for letter in word:
            temp = temp.children[ord(letter) - ord('a')]
            if temp.isEnd == False:
                flag = 1
        temp.isEnd = True
        if not flag:
            if (len(self.longest_string) < len(word)) or(len(self.longest_string) == len(word) and self.longest_string > word):
                self.longest_string = word

    def create_trie(self, words):
        for word in words:
            temp = self.root
            for letter in word:
                if temp.children[ord(letter) - ord('a')] == None:
                    node = TrieNode()
                    temp.children[ord(letter) - ord('a')] = node
                    temp = temp.children[ord(letter) - ord('a')]
                else:
                    temp = temp.children[ord(letter) - ord('a')]
            temp.isEnd = True

    def longestWord(self, words: List[str]) -> str:
        self.root = TrieNode()
        self.longest_string = ""
        self.create_trie(words)
        for word in words:
            self.checkLongestString(word)
        return self.longest_string

