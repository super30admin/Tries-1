"""
Sort words by length and lexicographically
Keep a set to store valid words that can be made
Check each word’s prefix; if valid, add it and update result
"""
"""
Time Complexity: O(N log N + N·L) —  sorting and prefix checking (L - max word length)
Space Complexity: O(N*L) — for set and string storage
"""


from typing import List

class longestWordDict:
    def longestWord(self, words: List[str]) -> str:
        words.sort()
        valid = set([""])
        result = ""

        for word in words:
            if word[:-1] in valid:
                valid.add(word)
                if len(word) > len(result):
                    result = word
        return result


if __name__ == "__main__":
    obj = longestWordDict()
    print(obj.longestWord(["w","wo","wor","worl","world"])) 
    print(obj.longestWord(["a","banana","app","appl","ap","apply","apple"]))  
