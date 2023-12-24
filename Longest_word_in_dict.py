# TC: O(N X L)
# SC: O(N X L)

class Solution:

    class TrieNode:
        def __init__(self):
            self.children=[None]*26
            self.isEnd=False

    def __init__(self):
        self.root=self.TrieNode()

    def insert(self,word):
        cur=self.root
        for i in range(0,len(word)):
            if cur.children[ord(word[i])-ord('a')]==None:
                cur.children[ord(word[i])-ord('a')]=self.TrieNode()
            
            cur=cur.children[ord(word[i])-ord('a')]
        cur.isEnd=True

    def find(self,cur,word,length):
        
        result=word
        for i in range(0,26):
            if cur.children[i] and cur.children[i].isEnd:
                temp=word+chr(i+ord("a"))
                temp_result=self.find(cur.children[i],temp,length+1)
                if len(temp_result)>len(result):
                    result=temp_result
        
        return result
            

    def longestWord(self, words: List[str]) -> str:
        for i in range(0,len(words)):
            self.insert(words[i])
        
        return self.find(self.root,"",0)
        print(self.result)
        print("done")

