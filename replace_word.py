# T.C --> O(N) ,where N is the length of the sentence
# S.C --> O(N) ,Size of the trie
class Trie:
    def __init__(self):
        self.root = {}

    def insert(self, word):
        node = self.root
        for letter in word:
            if letter not in node:
                node[letter] = {}
            node = node[letter]
        node["*"] = True

    def search(self, word):
        node = self.root
        res = ""
        for char in word:
            if char in node:
                res += char
                node = node[char]
                if "*" in node:
                    break
            else:
                break
        return res if "*" in node else word


class Solution:
    def replaceWords(self, roots: List[str], sentence: str) -> str:
        T = Trie()
        for word in roots:
            T.insert(word)
        return " ".join(map(T.search, sentence.split()))
