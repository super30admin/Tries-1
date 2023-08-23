# Time complexity : O(n*L) n is number of words, L is average length of each word
# Space complexity : O(size of dictionary) to store the trie
#TRIES ARE LAGGING, since 1st element is root and nothing is stored there -> ALWAYS LAGGING
class TrieNode:
    def __init__(self):
        self.Eow=False
        self.children=[None for _ in range(26)]

class Trie:
    def __init__(self):
        self.root=TrieNode()
    
    def insert(self,word):
        cur=self.root
        for w in word:
            idx=ord(w)-ord('a')
            if cur.children[idx]==None:
                cur.children[idx]=TrieNode()
            cur=cur.children[idx]
        cur.Eow=True
    
    def getreplacement(self,word):
        res=''
        cur=self.root
        for w in word:
            idx=ord(w)-ord('a')
            if cur.children[idx]==None: #if word doesn't have a prefix matcing letter, return the word, no replacement
                return word
            else:
                res+=w #build the res string
                if cur.children[idx].Eow==True: #check if we reached EOW, if we did return res so far -> new replacement
                    return res
            cur=cur.children[idx]
        return word
    
    

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        t=Trie()
        for d in dictionary: #add all prexfixes to the trie tree
            t.insert(d)
        res=''
        for string in sentence.split(' '): #get indiviual words from sentence
            res+=t.getreplacement(string)
            res+=' '
        
        return res.strip()


