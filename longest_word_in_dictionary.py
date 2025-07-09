# Time Complexity : O(n * k), where n is the number of words and k is the average length of a word
# Space Complexity : O(n * k), for storing all words in a set
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used a set to store all words for O(1) lookups.
# Then I sorted the words — by length descending and lexicographically ascending to prioritize longest and smallest words.
# For each word, I checked whether every prefix (from length 1 to len(word) - 1) existed in the set.
# If all prefixes were valid, I returned the word immediately.

from typing import List

class Solution:
    def longestWord(self, words: List[str]) -> str:
        word_set = set(words)
        words.sort(key=lambda w: (-len(w), w))  # sort by length desc, then lexicographically

        for word in words:
            valid = True
            for i in range(1, len(word)):
                if word[:i] not in word_set:
                    valid = False
                    break
            if valid:
                return word

        return ""
