//TC-o(nw)
//Sc-o(w)

class TrieNode:
    def __init__(self):
        self.children=[None]*26
        self.word=None
class Solution:
    def __init__(self):
        self.root=TrieNode()
    def longestWord(self, words: List[str]) -> str:
        for i in words:
            self.insert(i)
        q=[]
        q.append(self.root)
        word=""
        while q:
            curr=q.pop(0)
            word=curr.word
            for i in reversed(range(26)):
                if((curr.children[i]!=None) and (curr.children[i].word!=None)):
                    q.append(curr.children[i])
        return curr.word
        
        
    def insert(self,word):
        curr=self.root
        for i in word:
            ch=ord(i)-ord('a')
            if not curr.children[ch]:
                curr.children[ch]=TrieNode()
            curr=curr.children[ch]
        curr.word=word
