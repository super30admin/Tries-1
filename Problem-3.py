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
    def __init__(self):
        self.root = TrieNode()

    def createTrie(self, dictionary):
        for word in dictionary:
            temp = self.root
            for char in word:
                if temp.children[ord(char) - ord('a')] == None:
                    node = TrieNode()
                    temp.children[ord(char) - ord('a')] = node
                temp = temp.children[ord(char) - ord('a')]
            temp.isEnd = True

    def getPrefix(self, word):
        temp = self.root
        result = ""
        for char in word:
            if temp.children[ord(char) - ord('a')] == None:
                return word
            result += char
            temp = temp.children[ord(char) - ord('a')]
            if temp.isEnd:
                return result
        return word

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.createTrie(dictionary)
        words = sentence.split()
        for i in range(len(words)):
            words[i] = self.getPrefix(words[i])
        return " ".join(words)


