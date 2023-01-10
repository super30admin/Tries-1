#time complexity: O(sum(len(words)))
#space complexity: O(sum(len(words)))
#ran on leetcode: Yes
#Create a Node class which will point to 26 possible nodes, each representing a charcter. Initially these nodes are null and they are created when the character is encounterd.
class Trie:
    def __init__(self):
        self.end=False
        self.D=[None]*26

class Solution:
    def build(self,word,root):
        temp=root
        for i in word:
            ch = ord(i)-97
            if(temp.D[ch]==None):
                node=Trie()
                temp.D[ch]=node
            temp=temp.D[ch]
        temp.end=True
    
    def longest_word(self,root,curr,c):
        #print(type(curr))
        #print(type(self.st))
        if(root==None or root.end==False):
            if(len(curr)>len(self.st)):
                self.st=curr
            return

        curr+=c
        for i in range(0,26):
            #print(chr(i+97))
            self.longest_word(root.D[i],curr,chr(i+97))


    def longestWord(self, words: List[str]) -> str:
        root=Trie()
        root.end=True
        for word in words:
            self.build(word,root)
        self.st=""
        self.longest_word(root,"","")
        return self.st
        
        
