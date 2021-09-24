# // Time Complexity :O(max(m*k,n*l))
# // Space Complexity :O(m*k) worst case if there is no overlap
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



class TrieNode:
    def __init__(self):
        self.isEnd=False
        self.children=[False for i in range(26)]

class Trie:
    def __init__(self):
        self.root=TrieNode()
    def insert(self,word):
        curr=self.root
        
        for i in range(len(word)):
            c=word[i]
            if not curr.children[ord(c)-ord('a')]:
                curr.children[ord(c)-ord('a')]=TrieNode()
            curr=curr.children[ord(c)-ord('a')]
        curr.isEnd=True
                
        
class Solution:
    def __init__(self):
        self.trie=Trie()
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        result=" "
        for i in dictionary:
            self.trie.insert(i)
        sentence=sentence.split(' ')
        print(sentence)
        for i in range(len(sentence)):
            word=sentence[i]
            curr=self.trie.root
            stri=""
            for j in range(len(word)):
                c=word[j]
            
                if (not curr.children[ord(c)-ord('a')]) or curr.isEnd:
                    break
                stri=stri+word[j]
            
                curr=curr.children[ord(c)-ord('a')]
    
            if curr.isEnd:
                result=result+stri+" "
                
            else:
                result=result+word+" "
        return result.strip()
                
            
                    
                
            
            
            
            
            
        
        
        