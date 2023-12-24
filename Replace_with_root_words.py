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
    
    def replace(self,word):
        cur=self.root

        for i in range(0,len(word)):
            if cur.children[ord(word[i])-ord('a')]!=None:
                cur=cur.children[ord(word[i])-ord('a')]
                if cur.isEnd==True:
                    break
            else:
                return word

        return word[:i+1] 

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for i in range(0,len(dictionary)):
            self.insert(dictionary[i])
        
        lis=sentence.split(" ")
        res=[]
        for i in lis:
            res.append(self.replace(i))
        
        # print(res)
        result=(" ").join(res)
        return result

        