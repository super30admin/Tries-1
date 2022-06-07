#Using trie
#Time Complexity O(M * l)  for dictionary words of average l length, and O(N * k) for fpr number of words of k length
#Space Complexity O(M * N)
#It successfully runs on leetcode 
class TriNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isend = False
        
class Solution:
    def __init__(self):
        self.root = TriNode()
    
    def insert(self, word):
        cur = self.root
        for c in word:
            if cur.children[ord(c)-ord("a")] == None:
                cur.children[ord(c)-ord("a")] = TriNode()
            cur = cur.children[ord(c)-ord("a")]
        cur.isend = True
                                        
                                
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for i in dictionary:
            self.insert(i)
        st = sentence.split(" ")
        res = ""
        firstword = True
        for word in st:
            cur = self.root
            rs= ""
            for c in word:
                if cur.children[ord(c)-ord("a")] == None or  cur.isend==True:
                    break
                rs+=c
                cur = cur.children[ord(c)-ord("a")]
                
            if firstword: 
                res = res + rs if cur.isend else res+word
                firstword = False
            else:
                res = res + " " + rs if cur.isend else res + " " + word
        return res                            

#Approach: Using Hashset                                            
#Time Complexity O(M * l)  for dictionary words of average l length, and O(N * k^2) for fpr number of words of k length
#Space Complexity O(M)
#It successfully runs on leetcode 
        
class Solution:      
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        s = set()
        for i in dictionary:
            s.add(i) 
        st = sentence.split(" ")
        res = ""
        firstword = True
        for word in st:           
            prevlen = len(res)
            for c in range(len(word)):
                sub = word[:c]
                if sub in s:
                    res= res + sub  if firstword else res + " " + sub
                    break
            if prevlen==len(res):
                res= res + word if firstword else res + " " + word
            firstword = False
        return res                            
                            