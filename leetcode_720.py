class Solution:
    def longestWord(self, words: List[str]) -> str:
        words.sort()
        valid = set([""])
        ans = ""

        for w in words:
            if w[:-1] in valid:
                valid.add(w)
                if len(w) > len(ans):
                    ans = w

        return ans
        