class TrieNode:
    def __init__(self):
        self.children=dict()
        self.isEnd=False
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        root=TrieNode()
        #build trie
        for word in dictionary:
            curr=root
            for char in word:
                if char not in curr.children:
                    curr.children[char]=TrieNode()
                curr=curr.children[char]
            curr.isEnd=True
        
        res=""
        flag=False
        iFlag=False
        curr=root
        i=0
        while i<len(sentence):
            char=sentence[i]
            if char==" ":
                res+=char
                i+=1
                curr=root
                flag=False
                iFlag=False
                continue

            if flag:
                res+=char
                i+=1
                continue

            if iFlag:
                i+=1
                continue
            
            if char not in curr.children:
                res+=char
                flag=True
                i+=1
            else:
                res+=char
                i+=1
                curr=curr.children[char]
                if curr.isEnd:
                    iFlag=True
        
        return res


            
            
            
            
            





        


        