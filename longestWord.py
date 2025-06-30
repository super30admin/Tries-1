Time Complexity :O(Nxk) where is N is number of words and K is length of average word
Space Compelxity : O(N) where is N is lenght of answer
Approach:
#Brute force: For every string check if prefix exist(all prefixes) or not ..search can be done O(1) if used set ..getting prefixes increases complexity
#Sort+Set: sort the words and check if currnt_Word[:-1] exists in set ..maintain ansl and answ variables to keep track 
"""
    words.sort()
            s=set()
            ansl=0
            answ=""
            for i in words:
                if len(i)==1:
                    s.add(i)
                    if answ=="":
                        answ=i
                elif i[:-1] in s:
                    if ansl<len(i):
                        ansl=max(ansl,len(i))
                        answ=i
    
                    s.add(i)
            return answ
"""
# Optimal :use Trie add all words in trie 
#   -Use DFS to find answer . we can stop early if is_end is False or len(children)==0
#   -Use backtracking to make it more optimal



class TrieNode:
    def __init__(self):
        self.children={}
        self.is_end=False


class Trie:

    def __init__(self):
        self.root=TrieNode()
        

    def insert(self, word: str) -> None:
        curr=self.root
        for i in word:
            if i not in curr.children:
                curr.children[i]= TrieNode()

            curr=curr.children[i]
        curr.is_end=True
        

    def search(self, word: str) -> bool:
        curr=self.root
        for i in word:
            if i not in curr.children:
                return False

            curr=curr.children[i]
        return curr.is_end
        

    def startsWith(self, word: str) -> bool:
        curr=self.root
        for i in word:
            if i not in curr.children:
                return False

            curr=curr.children[i]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

class Solution:
    def longestWord(self, words: List[str]) -> str:
        # t=Trie()
        # for word in words:
        #     t.insert(word)
        # answords=[]
        # anslength=0
        self.answ=""
        self.ansl=0
        t=Trie()
        for i in words:
            t.insert(i)
        def dfsOnTrie(root,path,maxL):
            #base
            
            
            
            if  len(root.children)==0 :
                
                
                # ans.append((maxL,[i for i in path]))
                if len(path)>len(self.answ):
                    
                    self.answ="".join(path)
                    return 
                if len(path)==len(self.answ):
                    self.answ=min("".join(path),self.answ)
                    return 




            #logic
            for i in root.children:
                
                if root.children[i].is_end:
                   
                    path.append(i)
                    dfsOnTrie(root.children[i],path,maxL+1)
                    path.pop()
                else:
                    if len(path)>len(self.answ):
                    
                        self.answ="".join(path)
                         
                    if len(path)==len(self.answ):
                        self.answ=min("".join(path),self.answ)
                         
        dfsOnTrie(t.root,[],0)
        return self.answ
        
        # ansl,answ=0,""
        
        # for i in ans:
        #     if i[0]>ansl:
        #         ansl=i[0]
        #         answ=i[1]
        #     if i[0]==ansl and i[0]>0:
               
        #         answ=min(answ,i[1])
        # return "".join(answ)
