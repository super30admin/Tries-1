#time: O(n)
#space:O(n)

class Node:
    def __init__(self):
        self.isEnd=False
        self.children=[None for i in range(26)]
        
class Solution:
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.root=Node()
        for i in dictionary:
            self.insert(i)
        string=sentence.split()
        replaced=""
        for word in string:
            curr=self.root
            rword=""
            for c in word:
                s=ord(c)
                a=ord('a')
                if(curr.children[s-a]==None or curr.isEnd==True):
                    break
                else:
                    rword+=c
                    curr=curr.children[s-a]
            if(rword=="" or curr.isEnd==False):
                replaced+=word+" "
            else:
                replaced+=rword+" "
        return replaced.strip()
        
        
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr=self.root
        for c in word:
            s=ord(c)
            a=ord('a')
            if(curr.children[s-a]==None):
                curr.children[s-a]=Node()
            curr=curr.children[s-a]
        curr.isEnd=True
        
    