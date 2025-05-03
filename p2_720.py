# 720. Longest Word in Dictionary

# TC : O(n * log(n)), where n is the number of words
    # Sorting the words takes O(n * log(n))
    # Iterating through the words takes O(n)
    # Checking if a prefix is in the set takes O(1) on average
# SC : O(n), where n is the total length of all words
    # The word_set can contain up to n words
# Did this code successfully run on Leetcode : Yes

# Approach :
# The key insight is that a word can be built one character at a time if and only if all of its prefixes also exist in the dictionary. By sorting the words by length (and then lexicographically), we ensure that:
    # We process shorter words before longer ones, so all potential prefixes are already in the set
    # For words of the same length, we process lexicographically smaller ones first
# For each word, we check if it can be built by adding one character to a word we've already confirmed can be built. If so, we add it to our set of buildable words and update our longest word if applicable.

from ast import List


class Solution:
    def longestWord(self, words: List[str]) -> str:
        # Sort the words by length and then lexicographically
        # This ensures we process shorter words first and handle ties properly
        sorted_words = sorted(words, key=lambda x: (len(x), x))
        
        # Use a set for O(1) lookups
        word_set = set()
        
        # Add empty string as it's the starting point for building words
        word_set.add("")
        
        longest = ""
        
        for word in sorted_words:
            # Check if the word can be built by adding one character to a previous word
            if word[:-1] in word_set:
                # Add the current word to the set
                word_set.add(word)
                
                # Update the longest word if current word is longer
                if len(word) > len(longest):
                    longest = word
                # If same length, pick lexicographically smaller one
                elif len(word) == len(longest) and word < longest:
                    longest = word
        
        return longest