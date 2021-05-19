## Problem2
# Longest Word in Dictionary(https://leetcode.com/problems/longest-word-in-dictionary/)

class Solution:
    def longestWord(self, words: List[str]) -> str:
        words.sort()
        val = set()
        res = ''
        for w in words:
            if len(w)==1 or w[0:len(w)-1] in val:
                if len(w)>len(res):
                    res = w
                val.add(w)
        return res