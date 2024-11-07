class Solution:
    def longestWord(self, words: List[str]) -> str:
        words.sort(key=len)

        good_words = set()
        max_length = 0
        ans = ""
        for word in words:
            if len(word) == 1:
                good_words.add(word)
            elif word[:-1] in good_words:
                good_words.add(word)
            if word in good_words:
                if max_length < len(word):
                    max_length = len(word)
                    ans = word
                elif max_length == len(word):
                    ans = min(ans, word)
        return ans


# time complexity is O(n*l) where l is the average length of the words
# space complexity is O(n)
