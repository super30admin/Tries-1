class Solution:
    def longestWord(self, words: [str]) -> str:
        words_set = set([""])
        words.sort()
        ans = ""
        for word in words:
            if word[:-1] in words_set:
                if len(word) > len(ans):
                    ans = word
                words_set.add(word)
        return ans


r = Solution()
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
print("Longest word:", r.longestWord(words))
