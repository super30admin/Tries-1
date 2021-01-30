class Solution:
    '''
    Time Complexity: O(n)
    Space Complexity: O(n)
    
    '''
    class Trie:
        def __init__(self):
            self.alphabet = [None for i in range(0,26)]
            self.endWord = None
     
    def __init__(self):
        self.root = self.Trie()
            
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for w in dictionary:
            temp = self.root
            for x in w:
                i = ord(x)-ord('a')
                if(temp.alphabet[i]!=None):
                    temp = temp.alphabet[i]
                else:
                    temp.alphabet[i] = self.Trie()
                    temp = temp.alphabet[i]
            temp.endWord = w
            
        
        
        words = sentence.split()
        x = []
        for w in words:
            temp = self.root
            k=0
            for y in w:
                i = ord(y)-ord('a')
                if(temp.alphabet[i]==None):
                    k=1
                    x.append(w)
                    break
                else:
                    temp = temp.alphabet[i]
                    if(temp.endWord!=None):
                        k=1
                        x.append(temp.endWord)
                        break
            if(k==0):
                x.append(w)
            
        o = "" + x[0]
        for i in range(1,len(x)):
            o += " " + x[i]
        
        return o
