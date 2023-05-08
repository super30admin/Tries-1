# Time Complexity : O(N * M^2), where N is the number of words and M is the maximum length of a word
# Space COmplexity : O(N)
from typing import List
class Solution:
    def longestWord(self, words: List[str]) -> str:
        words.sort()  # Sort the words lexicographically
        longest_word = ""
        word_set = set(words)  # Convert the list of words to a set for efficient lookup

        for word in words:
            is_valid = True
            for i in range(1, len(word)):
                if word[:i] not in word_set:  # Check if all the prefixes of the word are present in the set
                    is_valid = False
                    break
            if is_valid and len(word) > len(longest_word):  # Update the longest word if the current word is valid and longer
                longest_word = word

        return longest_word