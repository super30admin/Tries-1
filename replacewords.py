"""
https://leetcode.com/problems/replace-words/
Need to stop as soon as we find flag=true
TC: O(mn)
SC: O(mn)
"""
class Trie:
    def __init__(self):
        self.children={}
        self.isEnd=False
    def insert(self, word):
        curr=self
        for w in word:
            if w not in curr.children:
                curr.children[w]=Trie()
            curr=curr.children[w]
        curr.isEnd=True
        print(curr,curr.isEnd,"x")
    def search(self, word):
        print(self.children)
        curr=self
        prefix=''
        for w in word:
            print(w)
            if w not in curr.children or curr.isEnd:
                break

            prefix+=w
            curr=curr.children[w]
        print(prefix)
        if curr.isEnd:
            return prefix
        else:
            return word

class Solution:
    def replaceWords(self, dictionary, sentence: str) -> str:
        s=[]
        result=""
        trie=Trie()
        print(trie)
        print(trie.children.values())
        for d in dictionary:
            print(d)
            trie.insert(d)
        s=sentence.split(" ")
        print(s)
        for split in s:
            result=result+trie.search(split)+" "
        return result.strip()

