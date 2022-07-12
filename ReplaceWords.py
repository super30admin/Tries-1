# 648. Replace Words
"""
Time Complexity : O(L * N) L = lenght of longest word
Space Complexity : O(l * N) N = number of words
"""
class TrieNode:
    isEnd = False
    children = []
    
    def __init__(self):
        self.isEnd = False
        self.children = [None]*26
    
    
class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        
        for i in range(0, len(word)):
            ch = word[i]
            pos = ord(ch) - ord('a')
            

            if curr.children[pos] == None:
                curr.children[pos] = TrieNode()
                
            curr = curr.children[pos]
        
        curr.isEnd = True
    

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        sb = ""
        for i in range(0, len(prefix)):
            ch = prefix[i]
            pos = ord(ch) - ord('a')
            
            if curr.children[pos] == None:
                return "#"
            
            else:    
                sb = sb + ch
                curr = curr.children[pos]
                
                if curr.isEnd == True:
                    return sb
                
        return sb
    
    
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        obj = Trie()
        #storing all the words of dictionayr into trie
        for word in dictionary:
            obj.insert(word)
        
        li = sentence.split(" ")
        #print(li)
        
        for i in range(0, len(li)):
            param_3 = obj.startsWith(li[i])
            #print("here", param_3, li[i])
            if param_3 != '#':
                li[i] = param_3
        
        #print(li)
        return " ".join(li)

        
