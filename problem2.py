#  Time complexity : O(nl)
#  Space complexity : O(nl)

class TrieNode:

    def __init__(self):
        self.children = [None] * 26
        self.word = None


class Solution:
    def insertTree(self,word):
        curr = self.root
        for c in word:
            if curr.children[ord(c)-ord("a")] == None:
                curr.children[ord(c)-ord("a")] = TrieNode()
            curr = curr.children[ord(c)-ord("a")]

        curr.word = word

    def longestWord(self, words: List[str]) -> str:
        if words == None or len(words) == 0:
            return ""
        self.root = TrieNode()
        self.root.word = ""
        for word in words:
            self.insertTree(word)

        curr = self.root
        queue = []

        queue.append(curr)

        while queue:
            curr = queue.pop(0)
            for i in range(25,-1,-1):
                if curr.children[i] is not None and curr.children[i].word is not None:
                    queue.append(curr.children[i])


        return curr.word




