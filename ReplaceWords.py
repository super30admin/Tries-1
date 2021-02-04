# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


class TrieNode:
    def __init__(self):
        self.children = {}
        self.isWord = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        currentNode = self.root
        for i in range(len(word)):
            c = word[i]
            if c not in currentNode.children:
                currentNode.children[c] = TrieNode()
            currentNode = currentNode.children[c]

        currentNode.isWord = True

    def search(self, word):
        currentNode = self.root
        replacement = ''
        for c in word:
            if c not in currentNode.children:
                break
            currentNode = currentNode.children[c]
            replacement += c
            if currentNode.isWord:
                return replacement
        return word


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        root = Trie()
        for word in dictionary:
            root.insert(word)
        res = ''
        for sent in sentence.split():
            if res:
                res += ' '
            res += root.search(sent)
        return res