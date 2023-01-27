#Time Complexity: O(n*l)+O(m*l)
#Space Complexity: O(n*l)+O(m*l)
#Successfully ran on leetcode

class Solution:
    class TrieNode:
        def __init__(self):
            self.isEnd = False
            self.children = [None]*26
    def __init__(self):
        self.root = self.TrieNode()
    def insert(self,word):
        curr = self.root
        for i in word:
            if not curr.children[ord(i)-ord('a')]:
                curr.children[ord(i)-ord('a')]=self.TrieNode()
            curr = curr.children[ord(i)-ord('a')]
        curr.isEnd = True
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if dictionary is None or len(dictionary)==0:
            return sentence
        for i in dictionary:
            self.insert(i)
        sentenceArr = sentence.split(" ")
        for i in range(len(sentenceArr)):
            s = ""
            curr = self.root
            for j in sentenceArr[i]:
                if not curr.children[ord(j)-ord('a')] or curr.isEnd:
                    break
                s+=j
                curr = curr.children[ord(j)-ord('a')]
            if curr.isEnd:
                sentenceArr[i]=s
        return " ".join(sentenceArr)
