#time,O(l),l of the words, space=O(m*k), m is the number of words and k is the average length of each words
class TrieNode:
    def __init__(self):
        self.children=[None for i in range(26)]
        self.isend=False
        
class Solution:
    def __init__(self):
        self.node=TrieNode()
    def insert(self,word):
        curr=self.node
        for i in word:
            if curr.children[ord(i)-ord('a')] is None:
                curr.children[ord(i)-ord('a')]=TrieNode()
            curr=curr.children[ord(i)-ord('a')]
        curr.isend=True
    def search(self,word):
        curr=self.node
        for i in word:
            curr=curr.children[ord(i)-ord('a')]
            if curr.isend is False:
                return False
            
        return True
        
                
        
    def longestWord(self, words: List[str]) -> str:
        l=-inf
        
        res=""
        for i in words:
            self.insert(i)
        for i in words:
            print(i)
            flag=self.search(i)
            print(flag)
            if flag==True:
                temp_l=len(i)
                if temp_l>l:
                    res=i
                    l=temp_l
                if temp_l==l:
                    if res>i:
                        res=i
        return res
                        
                    
                    
                    
                
        
        
        