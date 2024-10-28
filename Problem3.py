#648. Replace Words
class Solution(object):
    class TrieNodes:
        def __init__(self):
            self.isEnd = False
            self.children = [None] * 26
    def insert(self,dictionary): #O(D)
        for d in dictionary:
            curr = self.root
            for c in d:
                if curr.children[ord(c) - ord('a')] is None:
                    curr.children[ord(c) - ord('a')] = self.TrieNodes()
                curr = curr.children[ord(c) - ord('a')]
            curr.isEnd = True

    def replaceWords(self, dictionary, sentence):
        self.root = self.TrieNodes()
        result = ''
        self.insert(dictionary)
        i = 0
        for s in sentence.split(' '):
            if i > 0: result+=' '
            result += self.replace(s)
            i+=1
        return result
    def replace(self,s):
        curr = self.root
        new_s = ''
        for i in s:
            if curr.children[ord(i) - ord('a')] is None or curr.isEnd:
                return s
            curr = curr.children[ord(i) - ord('a')]
            new_s+=i
            if curr.isEnd:
                return new_s
        return s




    