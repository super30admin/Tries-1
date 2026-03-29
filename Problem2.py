#Longest Word in Dictionary

#Space -> O(NxL) N is number of words and L is the avg length of those words
#Time -> O(NxL) have to iterate over each character of each word 1st to store in trie then to evaluate result
#Logc -> save the words in tri, and then iterate over trie trying to find longest word that satisfy the constraint

from typing import List


class TrieDS:
    def __init__(self):
        self.charDIct={}
        self.isEnd = False

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trieNode = TrieDS()
        indexA = ord('a')
        result = ""
        maxLength = len(result)

        def insertInTrie(word):
            currentNode = trieNode
            for char in word:
                if char not in currentNode.charDIct:
                    currentNode.charDIct[char] = TrieDS()
                currentNode = currentNode.charDIct[char]
            currentNode.isEnd = True

        def helper(path, node):
            nonlocal result
            nonlocal maxLength
            if len(path) > maxLength:
                result = "".join(path)
                maxLength = len(path)
            keys = list(node.charDIct.keys())
            keys.sort()
            for char in keys:
                nextNode = node.charDIct[char]
                if nextNode != None and nextNode.isEnd:
                    path.append(char)
                    helper(path,nextNode)
                    path.pop()        
        for word in words:
            insertInTrie(word)
        helper([],trieNode)
        return result