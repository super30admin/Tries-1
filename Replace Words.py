""""// Time Complexity : O(m*L + n*L)->L=length of word
// Space Complexity : O(n*L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for i in range(26)]


class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            if curr.children[ord(word[i]) - ord('a')] == None:
                curr.children[ord(word[i]) - ord('a')] = TrieNode()
            curr = curr.children[ord(word[i]) - ord('a')]
        curr.isEnd = True


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for string in dictionary:
            trie.insert(string)
        sentence = sentence.split(" ")
        finalString = ""

        for k in range(len(sentence)):
            word = sentence[k]
            if k != 0:
                finalString += " "
            replacement = ''
            curr = trie.root
            for i in range(len(word)):
                c = word[i]
                if curr.children[ord(word[i]) - ord('a')] == None or curr.isEnd == True:
                    break
                replacement += c
                curr = curr.children[ord(word[i]) - ord('a')]
            if curr.isEnd == True:
                finalString += replacement
            else:
                finalString += word
        return finalString