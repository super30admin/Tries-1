#Time complexity : O(L)
#Space complexity : O(L) #L is the longest word
class TreeNode:
    def __init__(self):
        self.index= -1
        self.isend = False
        self.children = [False]*26

class Solution:
    def __init__(self):
        self.root = TreeNode()
        self.longest_string = ''
        
    def insert(self,word,index):
        
        cur = self.root
        for i,w in enumerate(word):
            word_ind = ord(w)-ord('a')
            if not cur.children[word_ind]:
                cur.children[word_ind] = TreeNode()
            cur = cur.children[word_ind]
        cur.isend = True
        cur.index=index
        
    def longestWord(self, words: List[str]) -> str:
        
        for index,word in enumerate(words):
            self.insert(word,index)
            
        stack = [children for children in self.root.children if children]
        
        while(stack):
            popped = stack.pop()
            if popped.isend:
                word = words[popped.index]

                if self.longest_string == '' or len(word) > len(self.longest_string) or (len(self.longest_string)==len(word) and word < self.longest_string):
                    self.longest_string = word
                for child in popped.children:
                    if child:
                        stack.append(child)
        return self.longest_string
        
        