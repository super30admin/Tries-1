class Solution:
    def longestWord(self, words: list[str]) -> str:
        words.sort()
        visited = {""}
        res = ''

        for word in words:
            if word[:-1] in visited:  # check previous word ie. word[:len(word)-1] visited or not
                visited.add(word)
                if len(word) > len(res):  # current word have greater length and lexicographically smaller
                    res = word

        return res