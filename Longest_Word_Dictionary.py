# Approach:
# We want to find the longest word in the list that can be formed by adding one character at a time,
# and each of its prefixes (except the full word itself) should be a valid word from the list.
# We use a set for fast lookup of words and sort the words lexicographically to handle lexicographical order in case of ties.

# Time Complexity: O(n * m + n log n) where n is the number of words and m is the average length of a word.
# Sorting the words takes O(n log n) and checking all prefixes for each word takes O(n * m), where m is the length of the word.
# Space Complexity: O(n) for storing the set of words.
# Did this code successfully run on Leetcode: Yes, the code runs successfully on Leetcode and passes all test cases.
# Any problem you faced while coding this: No issues, but ensuring lexicographical order while checking prefixes was key.

class Solution:
    def longestWord(self, words: List[str]) -> str:
        # Insert all words into a set for fast lookup
        word_set = set(words)
        longest_word = ""  # Initialize the longest word as an empty string
        
        # Sort the words lexicographically to ensure we can handle lexicographical order naturally
        words.sort()

        # Iterate through all words in the sorted list
        for word in words:
            # Check if the word can be built from its prefixes (from length 1 to len(word)-1)
            # If the word is longer than the current longest_word and all its prefixes exist in the set, update longest_word
            if len(word) > len(longest_word) and all(word[:i] in word_set for i in range(1, len(word))):
                longest_word = word

        return longest_word  # Return the longest valid word found
