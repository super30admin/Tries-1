# 648. Replace Words

# Time Complexity : O(nl) for insertion
# Space Complexity : 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Using Tries 


class Solution:
    
    class TrieNode:
        
        def __init__(self):
            self.word = ""
            self.children = [None] * 26
            
    
    def __init__(self):
        
        self.root = self.TrieNode()
        
    def insert(self, word_):
        
        curr = self.root
        
        for char in list(word_): 
            #print(word_, char)
            if curr.children[ord(char)-ord('a')] == None:
                curr.children[ord(char)-ord('a')] = self.TrieNode()
            curr = curr.children[ord(char)-ord('a')]
        
        curr.word = word_
    
    def search(self, word_) -> str:
        
        curr = self.root
        for char in word_:
            if curr.children[ord(char)-ord('a')] is not None:
                print(word_, char)
                #print(curr.children[ord(char)-ord('a')].word)
                if curr.children[ord(char)-ord('a')].word!="":
                    
                    return curr.children[ord(char)-ord('a')].word
                curr = curr.children[ord(char)-ord('a')]
            else:
                return word_
            
        return word_
        
            
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        for word in dictionary:
            self.insert(word)
        
        res_string = ""
        for s in sentence.split(" "):
            #print(s)
            res_string = res_string + self.search(s) +" "
        
        return res_string.strip()
            
        
        
        