"""
problem: replaceWords
t.c. => O(w * n) n = number of words and w = maxlength of a word
s.c. => O(w * n)
"""
class Trie:
    def __init__(self):
        self.isEnd = False
        self.map = [None for i in range(26)]

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        mainRoot = Trie()
        words = sentence.split(" ")

        
        for word in dictionary:
            root = mainRoot
            for c in word:
                idx = ord(c) - ord('a')
                if not root.map[idx]:
                    root.map[idx] = Trie()
                root = root.map[idx]
            root.isEnd = True
        
        res = []

        for word in words:
            root = mainRoot
            replace = []
            found = True
            for c in word:
                idx = ord(c) - ord('a')

                if root.isEnd:
                    break

                if not root.map[idx]:
                    found = False
                    break
                replace.append(c)
                root = root.map[idx]

            if not found:
                res.append(word)
            else:
                res.append("".join(replace))
        return " ".join(res)