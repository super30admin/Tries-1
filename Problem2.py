#Time Complexity :O(max(m*l,n*l))
#Space Complexity :O(max(m*l,n*l))
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.isEnd=False
        self.children=[None]*(26)
        
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.root=TrieNode()
        result=[]
        replacement=[]
        for word in dictionary: #n*l where n is the no of words and l is the average length of the words
            self.insert(word)

        sentArr=sentence.split()

        #m*l where m is the no of words in the sentence and l is the average length of the words
        for i in range(len(sentArr)):#m 
            word=sentArr[i]
            if i>0:
                replacement.append(" ")
            curr=self.root
            result=[]
            for j in range(len(word)):#l
                char=word[j]
                idx=ord(char)-ord('a')
                if not curr.children[idx] or curr.isEnd:
                    if result:
                        result=[]
                    break
                else:
                    result.append(char)
                    curr=curr.children[idx]
                    if curr.isEnd:
                        break
            if not result:
                replacement.append(word)
            else:
                replacement.append("".join(result))

        return ("".join(replacement))


    def insert(self,word):
        curr=self.root
        for i in range(len(word)):
            char=word[i]
            idx=ord(char)-ord('a')
            if not curr.children[idx]:
                curr.children[idx]=TrieNode()
            curr=curr.children[idx]
        curr.isEnd=True
