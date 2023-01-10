#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: Yes
#Create a Node class which will point to 26 possible nodes, each representing a charcter. Initially these nodes are null and they are created when the character is encounterd.
#After setting up the trie structure and inserting words from dictionary, loop through the sentence. For each word in the sentence, check if a shorter word 
#is present in Trie.If yes then use this shorter word. 
class Node:
    def __init__(self):
        self.end=False
        #self.end=False
        self.D=[None]*26

class Solution:
    

    def form_trie(self,word):
        temp=self.root
        for i in word:
            ch=ord(i)-97
            if(not temp.D[ch]):
                node=Node()
                temp.D[ch]=node
                temp=temp.D[ch]
            else:
                temp=temp.D[ch]
        temp.end=True
    
    def word_to_root(self,word):
        temp=self.root
        st=""
        for i in word:
            ch=ord(i)-97
            if(temp.D[ch]==None):
                for j in range(0,26):
                    if(temp.D[j]!=None):
                        return word
                return st
            else:
                st+=i
                temp=temp.D[ch]
                if(temp.end==True):
                    #st+=i
                    return st
        
        return word
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.root=Node()
        for i in dictionary:
            self.form_trie(i)
        
        op=""
        for word in sentence.split(" "):
            #print(word)
            res=self.word_to_root(word)
            if(res==""):
                op=op+word+" "
            else:
                op=op+res+" "
        return op[:-1]
