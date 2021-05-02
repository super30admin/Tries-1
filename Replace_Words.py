class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = None


class Solution:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for c in word:
            if not curr.children[ord(c) - ord('a')]:
                curr.children[ord(c) - ord('a')] = TrieNode()
            curr = curr.children[ord(c) - ord('a')]

        curr.isEnd = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if not dictionary:
            return sentence

        for word in dictionary:
            self.insert(word)

        str_array = sentence.split()
        # print (str_array)
        result = []

        for i in str_array:
            curr = self.root
            replacement = []
            for j in i:
                if not curr.children[ord(j) - ord('a')] or curr.isEnd:
                    break
                replacement.append(j)
                curr = curr.children[ord(j) - ord('a')]
            # print (replacement)
            if curr.isEnd:
                result.append("".join(replacement))
            else:
                result.append(i)

        return " ".join(result)