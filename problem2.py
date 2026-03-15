# problem 2 

# https://leetcode.com/problems/longest-word-in-dictionary/

class Solution:

    class Tries:
        def __init__(self):
            self.node = {}
            self.end_word = False


    def insertNode(self,word):
        current = self.root
        for w in word:
            if w not in current.node:
                current.node[w] = self.Tries()
            current = current.node[w]
        current.end_word = True



    def longestWord(self, words: List[str]) -> str:
        self.root = self.Tries()
        for word in words:
            self.insertNode(word)
        
        result_str = ''
        for word in words:
            if len(word) < len(result_str):
                continue 
            current = self.root
            for w in word:
                current = current.node[w]
                if not current.end_word:
                    break
            if current.end_word and (len(word) > len(result_str) or (len(word) == len(result_str) and word < result_str)):
                result_str = word 
        return result_str
