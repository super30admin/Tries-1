# Time complexity: O(n^2)
# Space Complexity: O(n)
# Algorithm: Sort the words and then for each word if the string upto previous character is in a set then place the word in the set.
#            Sort the set and return max value (with min lexical order)
class Solution:
    def longestWord(self, words: List[str]) -> str:
        sorted_words = sorted(words)
        word_set = set()
        for i in sorted_words:
            (len(i[:-1]) == 0 or (i[:-1] in word_set)) and word_set.add(i)
        count = 0
        result = ""
        
        for i in sorted(word_set):
            if len(i) > count:
                result = i
                count = len(i)
        return result