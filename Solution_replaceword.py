"""
Time complexity O(M*P)+O(N*P)-->Max(M,N)*P [Insert + replace]
Space complexity O(MP)
                   

"""

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = {}


class Solution_replaceword:
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word):
        curr = self.root
        for c in word:
            if c not in curr.children:
                curr.children[c]=TrieNode()
            curr=curr.children[c]
        curr.isEnd= True
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        replace=""
        res=""
        self.root=TrieNode()
        for word in dictionary:
            self.insert(word)
        sent=sentence.split()
       
        for i,word in enumerate(sent):
            curr=self.root
            replace=""
            if(i!=0):
                res+=" "
            for w in word:
                
                if w not in curr.children or curr.isEnd:
                    break
                replace+=w
                
                curr=curr.children[w]
            if curr.isEnd:
                res+=replace
                
            else:
                res+=word
                
        return res      
                
               
                    
            
        
        