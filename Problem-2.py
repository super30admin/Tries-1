
# 720. Longest Word in Dictionary

'''
Leetcode all test cases passed: Yes
Solution:
    def longestWord(self, words: List[str]) -> str:
      n is length of words
      Time Complexity: O(n log n) 
      Space Complexity: O(n)
'''
class Solution:
    def longestWord(self, words: List[str]) -> str:
        words.sort()
        s = set()
        result = ""
        for word in words:
            if len(word) == 1:
                s.add(word)
                if len(result) == 0:
                    result = word
            if word[:-1] in s:
                s.add(word)
                if len(word) > len(result):
                    result = word
        return result
