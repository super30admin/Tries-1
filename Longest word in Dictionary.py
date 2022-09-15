# TC: O(maxlen(word))
# SC: SC: O(Sum(len(words))) - To build the Tries
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26
             
class Trie:
    def __init__(self):
        self.root = TrieNode()
        
    def getRoot(self):
        return self.root
    
    def insert(self,word):
        curr = self.root
        for char in word:
            index = ord(char)-ord('a')
            if curr.children[index]==None:
                curr.children[index]=TrieNode()
                
            curr = curr.children[index]
            
        curr.isEnd = True
        
class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for word in words:
            trie.insert(word)
        root = trie.getRoot()
        self.result = []
        self.backtrack(root,[])
        return "".join(self.result)
        
    def backtrack(self,root,longword):
        #base
        if len(self.result)<len(longword):
            self.result = longword[:]
        
        #logic
        for index in range(26):
            if root.children[index] and root.children[index].isEnd==True:
                #action
                longword.append(chr(index+ord('a')))
                
                #recurse
                self.backtrack(root.children[index],longword)
                
                #backtrack
                longword.pop()
            
