# TC = O((N *l) + (m* l)) | SC = O((N *l) + (m* l)) N > No of words in dict, m > no of words in sentence
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for _ in range(26)]


class Solution:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str):
        curr = self.root
        for i in range(len(word)):
            c = ord(word[i])
            if curr.children[c - ord('a')] == None:
                curr.children[c - ord('a')] = TrieNode()
            curr = curr.children[c - ord('a')]
        curr.isEnd = True

    def replaceWords(self, dictionary: list[str], sentence: str) -> str:
        self.root = TrieNode()
        for word in dictionary:
            self.insert(word)

        sb = ""
        split_arr = sentence.split(" ")
        for i in range(len(split_arr)):
            if i > 0: sb += " "
            sb += self.getShortestVersion(split_arr[i])
        return sb

    def getShortestVersion(self, word: str):
        curr = self.root
        sb = ""
        for n in word:
            c = ord(n)
            if curr.children[c - ord('a')] == None or curr.isEnd:
                break
            curr = curr.children[c - ord('a')]
            sb += n
        if curr.isEnd: return sb
        return word
