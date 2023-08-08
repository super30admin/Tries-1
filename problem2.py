# Space complexity: O(N)
class Solution:
    def longestWord(self, words: List[str]) -> str:
        words.sort()  # Sort the words lexicographically  # O(N * log N)
        word_set = set([""])
        longest_word = ""
        
        for word in words: # O(N)
            if word[:-1]  in word_set: # len(prefix)
                word_set.add(word)
                if len(word) > len(longest_word):
                    longest_word = word
        
        return longest_word
