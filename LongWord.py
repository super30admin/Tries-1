# BFS
# Time Complexity  nlogn + n *(2* avg len of word)
# Space Complexity o(n) sum of length all of the words
class TrieNode:
    
    def __init__(self,char):
        
        self.children = [None]*26
        self.isEnd = True
        self.char = char
        self.isWord = False
        self.word = None
            

class Solution:
    
    def __init__(self):
        self.trie = TrieNode("0")
        self.trie.isWord == True
    
    def insert(self,word):
        
        curr = self.trie
   
        for a in word:
            
            childIndex = ord(a) - ord('a')
            
            if curr.children[childIndex] == None:
                curr.children[childIndex] = TrieNode(a)
                
            curr = curr.children[childIndex]
        curr.isWord = True
        curr.word = word
    
            
           
            
    def longestWord(self, words: List[str]) -> str:
        
        for a in words:
            self.insert(a)
        qu = collections.deque()
        qu.append(self.trie)
        curr = 0
        while(qu):
            curr = qu.popleft()
            for i in range(len(curr.children)-1,-1,-1):
                
                if curr.children[i] != None and curr.children[i].isWord:
                        qu.append(curr.children[i])
                       
        
        if curr.word == None:
            return ""
            
        return curr.word
        
            
        
        
        
        
        
        
        