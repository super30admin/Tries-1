#Time complexity: O(NL)
#Space complexity: O(NL)

class Solution:
    class TrieNode:
        def __init__(self):
            self.lst=[None]*26
            self.flag=False
            
    def insert(self, word: str) -> None:
        curr=self.root
        for i in range(len(word)):
            char=word[i]
            if curr.lst[ord(char)-ord("a")] is None:
                curr.lst[ord(char)-ord("a")]=self.TrieNode()
            curr=curr.lst[ord(char)-ord("a")]
        curr.flag=True
            
    def longestWord(self, words: List[str]) -> str:
        self.root= self.TrieNode()
        for i in words:
            self.insert(i)
        self.res=[]
        self.helper(self.root,[])
        return ''.join(self.res)
        
    def helper(self,curr, word):
        if not curr:
            return
        if(len(word)>len(self.res)):
            self.res=word.copy()
        
        for i in range(0,26):
            if(curr.lst[i] and curr.lst[i].flag):
                word.append(chr(ord('a')+i))
                self.helper(curr.lst[i], word)
                word.pop()
        
        
        
        