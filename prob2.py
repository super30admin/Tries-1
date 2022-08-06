#TC : 0(N)
#SC: 0(N)
class TrieNode:
    def __init__(self):
        self.child = {}
        self.isEnd = False
    
    
class Solution:
    def __init__(self):
        self.root = TrieNode()
    def insert(self,val):
        cur = self.root
        for i in val:
            if i not in cur.child:
                cur.child[i] = TrieNode()
            cur = cur.child[i]
        cur.isEnd = True
    
    def search(self,val):
        cur = self.root
        s = ''
        for i in val:
            if i not in cur.child:
                return ''
            s+=i
            cur = cur.child[i]
            if(cur.isEnd == True):
                return s
        return ''
        
            
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for i in dictionary:
            self.insert(i)
        output = []
        for i in sentence.split():
            res = self.search(i)
            if(res!=''):
                output.append(res)
            else:
                output.append(i)
        return ' '.join(output)
            
            
        
            
        
        