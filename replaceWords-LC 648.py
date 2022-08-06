# Time Complexity = O(n * l) + O(m * k), where n = no. of words in dictionaty, l = avg length of those words, m = no. of words in the sentence, k = avg length of those words

# Space Complexity = O(n * l)


class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False
    
    
class Solution:
    def __init__(self):
        self.root = TrieNode()
        
    
    def insert(self, word):
        curr = self.root
        for char in word:
            c = ord(char) - ord('a')
            if curr.children[c] == None:
                curr.children[c] = TrieNode()
                #curr.children[c].val = char         # Optional
            
            curr = curr.children[c]
        
        curr.isEnd = True
        
        
    def search(self, word):
        curr = self.root
        string = ""
        for char in word:
            c = ord(char) - ord('a')
            
            # If no trie found, return empty string, else append the char to string to give out the smaller replacement of the word
            if curr.children[c] == None :
                return ""
            
            string += char
            curr = curr.children[c]
            
            # If isEnd is True, it means that a smaller replacement is found, return the formed string
            if curr.isEnd == True:
                return string
        
        return ""
        
        
    
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
            self.insert(word)
       
        stringList = sentence.split()
        final = ""
        
        for i in range(len(stringList)):
            # to separate the formed sentence with spaces
            if (i != 0):
                final += " "
                
            strs = stringList[i]
            ret = self.search(strs)
            
            if (ret != ""):
                final += ret
            else:
                final += strs
        
        return final
                
            
            
        
        
        
        