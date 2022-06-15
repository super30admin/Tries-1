#Time complexity: O(mL)+O(sentence length)
#Space complexity: O(26*m*L)-> creating Trie for m elements in dictionary, 
class Solution:
    root=None
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
        
    def replaceWords(self, dictionary, sentence: str) -> str:
        self.root=self.TrieNode()
        for i in dictionary:
            self.insert(i)
        words=sentence.split()
        res=""
        for i in range(len(words)):
            curr=self.root
            temp=""
            for j in range(len(words[i])):
                if curr.lst[ord(words[i][j])-ord("a")] is None or curr.flag==True:
                    break
                temp+=words[i][j]
                curr=curr.lst[ord(words[i][j])-ord("a")]
            if curr.flag==True:
                res+=temp
                res+=" "
            else:
                res+=words[i]
                res+=" "
        return res[:len(res)-1]
            
        
        
        
