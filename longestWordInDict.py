#TimeComplexity:O(N*M ) where N is no of words and  M is length of longest word 
#SpaceComplexity: O(M*N)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    def __init__(self):
        self.dict={}
        self.isWord='-'
        
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        temp = self.dict
        for c in word:
            if c in temp:
                temp = temp[c]
            else:
                temp[c] = {}
                temp = temp[c]
        temp[self.isWord] = self.isWord
    def longestWord(self, words: List[str]) -> str:
        global1=''
        temp=self.dict
        for word in words:
            self.insert(word)
        for word in words:
            str1= ''
            temp=self.dict
            for c in word:
                if c in temp and self.isWord in temp[c]:
                    str1+=c
                    temp=temp[c]
            if len(global1)==len(str1):
                lex=[global1,str1]
                X=sorted(lex)
                global1=X[0]
            elif (len(global1)<len(str1)):
                global1=str1 

        return global1
                    
                
        