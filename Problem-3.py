#Time Complexity :O(n) 
#Space Complexity :O(n) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
import re
class Solution(object):
    class TrieNode():
        isTrue=None
        children=None
        def __init__(self):
            self.children=[None]*26
            self.isTrue=False
    
    
    def __init__(self):
        self.root=self.TrieNode()
        
    def insert(self,word):
        curr=self.root
        for i in word:
            if(curr.children[ord(i)-ord('a')]==None):
                curr.children[ord(i)-ord('a')]=self.TrieNode()
            curr=curr.children[ord(i)-ord('a')]
        
        curr.isTrue=True 
    
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        result=""
        sentence=re.sub('\s\s+'," ",sentence)
        arr=list(sentence.split(' '))
        
        for i in dictionary:
            self.insert(i)
        
        for k in range(len(arr)):
            curr=self.root
            replacement=""
            if(k>0):
                result+=" "
            for i in arr[k]:
                if(curr.children[ord(i)-ord('a')]==None or curr.isTrue==True):
                    break
                replacement+=i
                curr=curr.children[ord(i)-ord('a')]
            
            if(curr.isTrue==True):
                result+=replacement
            else:
                result+=arr[k]
        
        return result
        
        
    
     
    
        
        
        
        