# time complexity : Insert, Search, startswith : O(m*n)+O(kl) where n is the length of the word
# Space complexity: o(m*n) + O(k) where m is the number of word and n is the avg length of the word
# k is the number of word in string and l is the avg length of word in string

class TrieNode:

    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False


class Solution:

    def insert(self, word):
        curr = self.root

        for c in word:
            if curr.children[ord(c) - ord("a")] is None:
                curr.children[ord(c) - ord("a")] = TrieNode()

            curr = curr.children[ord(c) - ord("a")]

        curr.isEnd = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:

        self.root = TrieNode()

        for word in dictionary:
            self.insert(word)

        arr = sentence.split(" ")
        result = ""
        for word in arr:
            result += " "
            curr = self.root
            replacement = ""
            for i in range(0, len(word)):
                c = word[i]

                if curr.children[ord(c) - ord("a")] is None or curr.isEnd == True:
                    break

                replacement += c
                curr = curr.children[ord(c) - ord("a")]

            if curr.isEnd:
                result += replacement
            else:
                result += word

        return result.strip()