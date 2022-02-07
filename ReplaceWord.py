# Time Complexity o(nl) + o(mk) where n is the number of words in dictionary and l is the average length of the word in dictionary . Where m is the number of words in the sentence and k is the average length of the words in the sentence

# We are iterating over the dictionary first and inserting the dictionary words character by character
# We are checking each word in the sentence for the prefix in the trie
# Space Complexity o(nl)
# Used a Trie Data structure to create a prefix tree of the dictionary
# iterate through the trie to see if prefix exits and replace it
# 

class TrieNode:
     
    def __init__(self,char):
        
        self.char = char
        self.isEnd = False
        self.children = [None]*26

class Solution:
    
    def __init__(self):
        self.trie = TrieNode(0)
        self.trie.isWord = True
    
    def insert(self,word):
        
        curr = self.trie
   
        for char in word:
            childIndex = ord(char)  - ord('a')
            if curr.children[childIndex] == None:
                curr.children[childIndex] = TrieNode(char)
            curr = curr.children[childIndex]
        curr.isEnd = True
        

    
        
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        result = []
        ls = sentence.split(" ")
        for word in dictionary:
            self.insert(word)
    
        for word in ls:
            curr = self.trie
            replacement = ""
            for char in word:
               
                if curr.children[ord(char) - ord('a')] == None or curr.isEnd == True:
                    break
                curr = curr.children[ord(char) - ord('a')]
            
                replacement += char
            if curr.isEnd == True:
                result.append(replacement)
            else:
                result.append(word)
           
        return " ".join(result)
                
                    
                
            
            
            
            
            
                
                
                
        