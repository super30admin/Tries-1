class Solution:
    def longestWord(self, words):
        wordSet = set(words)
        result = ""

        for word in words:
            valid = True

            for i in range(1, len(word)):
                if word[:i] not in wordSet:
                    valid = False
                    break

            if valid:
                if len(word) > len(result) or \
                   (len(word) == len(result) and word < result):
                    result = word

        return result

# Time: O(N * L^2), where N is the number of words and L is the average length 
# Space: O(N * L) for storing all the words in the set.