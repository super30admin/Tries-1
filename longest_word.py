# Time Complexity: O(N*M)
# Space Complexity: O(N)

class Solution:
    def longestWord(self, words: List[str]) -> str:
        word_set = set(words)
        longest_word = ""

        for word in words:
            valid = True
            for i in range(1, len(word)):
                if word[:i] not in word_set:
                    valid = False
                    break

            if valid:
                if len(word) > len(longest_word):
                    longest_word = word
                elif len(word) == len(longest_word) and word < longest_word:
                    longest_word = word

        return longest_word
