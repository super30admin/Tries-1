#Time complexity: O(n*k)
#Space complexity: O(n*k)
#Did this code successfully run on Leetcode : yes
class TrieNode:
    
    def __init__(self):
        self.children = {}
        self.isEnd = False

class Solution:
#Initialize Trie  
    def __init__(self):
        self.root = TrieNode()
 
#for creating Trie
    def insert(self,word):
        cur = self.root
        
        for i in word:
            if i not in cur.children:
                cur.children[i]=TrieNode()
            cur=cur.children[i]
        cur.isEnd = True

#For seraching in trie
    def search(self,word):
        cur = self.root
        st=""
        for i in word:
            if i not in cur.children:
                break
            st+=i
            cur=cur.children[i]
            if cur.isEnd:
                return st
        return word
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
    #Creating, searching in trie and returning the replacement sentence
        for i in dictionary:
            self.insert(i)
        
        res=""
        for s in sentence.split(" "):
            if res:
                res+=" "
            res+=self.search(s)
            
        return res