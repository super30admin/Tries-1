#time=O(mn) 
#space=O(mn)

class node:
    def __init__(self):
        self.word=""
        self.children=[None for i in range(26)]
class Solution:
    def longestWord(self, words: List[str]) -> str:
        self.root=node()
        for i in words:
            self.insert(i)
        curr=self.root
        i=25
        result=""
        q=deque()
        q.append(curr)
        while(q!=deque()):
            i=25
            curr=q.popleft()
            while(i>=0):
                if(curr.children[i]!=None and curr.children[i].word!="" ):
                    q.append(curr.children[i])
                    
                i-=1
                    
        return curr.word
                   
        
    def insert(self,word):
        curr=self.root
        for w in word:
            s=ord(w)
            c=ord('a')
            if(curr.children[s-c]==None):
                curr.children[s-c]=node()
            curr=curr.children[s-c]
        curr.word=word
    
           
        