import collections
from typing import List

class TrieNode:
    def __init__(self):
        self.word = ''
        self.children = [None for _ in range(26)]


class Solution:
    def __init__(self):
        self.root = TrieNode()

    def buildthetries(self, word: str) -> None:
        ptr = self.root
        for charcater in word:
            if ptr.children[ord(charcater) - ord('a')] == None:
                ptr.children[ord(charcater) - ord('a')] = TrieNode()
            ptr = ptr.children[ord(charcater) - ord('a')]

        ptr.word = word

    def longestWord(self, words: List[str]) -> str:
        if words is None or len(words) == 0: return str

        for word in words:
            self.buildthetries(word)

        dfsqueue = collections.deque()
        ptr = self.root
        dfsqueue.append(ptr)
        pointer = None
        while dfsqueue.__len__() > 0:
            pointer = dfsqueue.pop()
            for idx in range(25,-1,-1):
                #print(idx)
                if pointer.children[idx] != None and pointer.word != None:
                    dfsqueue.append(pointer.children[idx])

        return pointer.word
if __name__ == '__main__':
    words=["m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"]
    print(Solution().longestWord(words=words))

    # for  idsx in range(25,-1,-1):
    #
    #     print(idsx)