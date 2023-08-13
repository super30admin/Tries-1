#TC:O(N*K) where N is the number of words in the list and K is the average length of words
#SC:O(N) where N is the number of words in the list.
class Solution:
    def longestWord(self, words: List[str]) -> str:
        def is_buildable(word):
            return all(word[:k] in word_set for k in range(1, len(word)))

        word_set, longest = set(words), ""
        
        for word in words:
            if len(word) > len(longest) or (len(word) == len(longest) and word < longest):
                if is_buildable(word):
                    longest = word
        return longest