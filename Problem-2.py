#Time Complexity :O(m*n) 
#Space Complexity :O(m*n) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    
    class TrieNode():
        word=None
        children=None
        def __init__(self):
            self.children=[None]*26
            self.word=None
    
    def __init__(self):
        self.root=self.TrieNode()
        
    def inserWord(self,word):
        curr=self.root
        for i in word:
            if(curr.children[ord(i)-ord('a')]==None):
                curr.children[ord(i)-ord('a')]=self.TrieNode()
            curr=curr.children[ord(i)-ord('a')]
        
        curr.word=word 
    
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        if(words==None or len(words)==0):
            return ""
        
        for word in words:
            self.inserWord(word)
        queue=collections.deque()
        queue.append(self.root)
        curr=None
        while(queue):
            curr=queue.popleft()
            for i in range(25,-1,-1):
                if(curr.children[i]!=None and curr.children[i].word!=None):
                    queue.append(curr.children[i])
        
        return (curr.word)
                    
        
        
        
        