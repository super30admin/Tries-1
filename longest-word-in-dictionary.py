# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def longestWord(self, words: List[str]) -> str:
        words.sort()
        word_set = {""}
        longest_word = ""
        for word in words:
        words.sort()
        word_set = {""}
        longest_word = ""
        for word in words:
            if word[:-1] in word_set:
                word_set.add(word)
                if len(word) > len(longest_word):
                    longest_word = word
        return longest_word
        