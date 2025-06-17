# Time Complexity : O(NL)
# Space Complexity : O(NL)

class TrieNode:
        def __init__(self):
            self.children={}
            self.IsEnd=False

class Solution:
    def __init__(self):
        self.root=TrieNode()

    def Insert(self, word):
        curr = self.root
        for i in word:
            if (i not in curr.children):
                curr.children[i]=TrieNode()    
            curr=curr.children[i]
        curr.IsEnd=True

    def search(self, word):
        curr = self.root
        osf = ''
        for i in word:
            if i not in curr.children: 
                break
            curr = curr.children[i]
            osf += i
            if curr.IsEnd:
                 return osf
        return word

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        curr=self.root
        for wd in dictionary:
            self.Insert(wd)

        stl=sentence.split(" ")
        res=""

        for k in stl:
            if res:
                res+=" "

            res+=str(self.search(k))
        return res