# // Time Complexity : O(length of words in array)
# // Space Complexity : O(Space used by trie)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : Followed approach from class
# longest word
class TrieNode:
    def __init__(self, char):
        self.char = char
        self.children = [None] * 26
        self.isWord = False

class MaxWord:
    def __init__(self):
        self.word = ""
        self.maxLen = 0

class Solution:
    def __init__(self):
        self.trie = TrieNode("0")
        self.trie.isWord = True

    def insert(self, word):
        t = self.trie
        for char in word:
            childIdx = ord(char) - ord('a')
            if not t.children[childIdx]:
                newNode = TrieNode(char)
                t.children[childIdx] = newNode
            t = t.children[childIdx]
        t.isWord = True

    def search(self, word):
        t = self.trie
        for char in word:
            childIdx = ord(char) - ord('a')
            if not t.children[childIdx]:
                return False
            t = t.children[childIdx]

        return True

    def longestWord(self, words: List[str]) -> str:
        words.sort() # nlog(n)
        maxWord = MaxWord()
        for word in words: # n
            if self.search(word[:len(word) - 1]): # average length of word
                self.insert(word) # average lenght of word
                if len(word) > maxWord.maxLen:
                    maxWord.word = word
                    maxWord.maxLen = len(word)
        # total = nlog(n) + n * (2 * average length of word)

        return maxWord.word