# Time Complexity : O(nk + ml)
# Space Complexity : O(nk + ml)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import List
class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False
class Solution:
    def __init__(self):
        self.root = TrieNode()
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for str in dictionary: #nk
            self.insert(str)
        
        strArr = sentence.split()
        result = ""
        for word in strArr:
            replacement = ""
            curr = self.root
            for c in word:
                if curr.children[ord(c)-ord('a')] is None or curr.isEnd:
                    break
                curr = curr.children[ord(c)-ord('a')]
                replacement+=c
        
            if(curr.isEnd):
                result += replacement
            else:
                result += word
            result += ' ' 
        
        return result[:-1]

        
    def insert(self, word):
        curr = self.root
        for c in word:
            if curr.children[ord(c)-ord('a')] is None:
                curr.children[ord(c)-ord('a')] = TrieNode()
            curr = curr.children[ord(c)-ord('a')]
        curr.isEnd = True

#Approach 2: Using set
# Time Complexity : O(nl + mk^2) n->total no.of words in dic, 
#l -> avg len of words in dic, m -> total no.of words in sentence, k -> avg len of each word in sentence
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        sets = set(dictionary)
        strArr = sentence.split()
        result = ""

        for i in range(0, len(strArr)):
            word = strArr[i]
            if(i > 0):
                result += ' '
            flag = False
            for k in range(0, len(word)):
                sub = word[0:k+1]
                if sub in sets:
                    flag = True
                    result += sub
                    break
            if not flag:
                result += word
        
        return result