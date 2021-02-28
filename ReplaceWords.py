#TimeComplexity:O(N*M) n is no of words and M is the longest word without prefix. 
#SpaceComplexity: O(M*N)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    def __init__(self):
        self.dict={}
        self.isWord='-'
        
    def insert(self,word):
        temp=self.dict
        for ch in word:
            if ch in temp:
                temp=temp[ch]
            else:
                temp[ch]={}
                temp=temp[ch]
        temp[self.isWord]=self.isWord
        
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        output=[]
        words=sentence.split(' ')
        
        for word in dictionary:
            self.insert(word)
        for word in words:
            cur=''
            temp=self.dict
            for ch in word:
                if ch in temp and self.isWord in temp[ch]:
                    cur+=ch
                    output.append(cur)
                    break
                elif ch not in temp:
                    output.append(word)
                    break
                else :
                    cur+=ch
                    if len(cur)==len(word):
                        output.append(cur)
                        break
                    temp=temp[ch]
        return ' '.join(output)
        
        