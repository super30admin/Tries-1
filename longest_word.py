class Solution(object):
    def longestWord(self, words):
        ans = ""
        for word in words:
            if len(word) > len(ans) or len(word) == len(ans) and word < ans:
                if all(word[:k] in words for k in range(1, len(word))):
                    ans = word
        return ans