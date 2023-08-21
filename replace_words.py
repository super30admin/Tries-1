# Time Complexity :O(M*N)
# Space Complexity :O(M)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


class TrieNode:
    def __init__(self, val) -> None:
        self.val=val
        self.children=[None for i in range(26)]
        self.is_end=False

class Trie:
    def __init__(self) -> None:
        self.root=TrieNode(" ")
    def insert(self, word):
        
        temp=self.root
        for i in word:
            node=TrieNode(i)
            if(temp.children[ord(i)-ord('a')]==None):
                temp.children[ord(i)-ord('a')]=node
            temp=temp.children[ord(i)-ord('a')]
        temp.is_end=True

    def search(self, word):
        temp=self.root
        replace=""
        for i in word:
            if(i==" "):
                continue
            
            if(temp.children[ord(i)-ord('a')]==None):
                return (False, "")
            # print("yes")
            replace+=i            
            temp=temp.children[ord(i)-ord('a')]
            if(temp.is_end):
                break
        return (temp.is_end, replace)

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        obj=Trie()
        for i in dictionary:
            obj.insert(i)
        # l=sentence.split(" ")
        w=""
        return_str=""
        for i in range(len(sentence)):
            # print(l[i])
            if(sentence[i]==" " or i==len(sentence)-1):
                if(i==len(sentence)-1):
                    w+=sentence[i]
                r=obj.search(w)
                if(r[0]):
                    return_str=return_str+r[1]+" "
                else:
                    return_str=return_str+w+" "
                w=""
                continue
                
            w+=sentence[i] 
            
        return return_str.rstrip()


