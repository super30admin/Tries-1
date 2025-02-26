# TC - Building the Trie: 𝑂 ( 𝑁 ⋅ 𝐿 )  Processing the sentence: 𝑂 ( 𝑀 ⋅ 𝐿 ) O(M⋅L)
#Sc - O(N*L)
class Solution:
    def __init__(self):
        self.root = TrieNode()

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        result = []
        for word in dictionary:
            self.insert(word)
        splitsentence  = sentence.split(" ")
        for word in splitsentence:
            prefixString = self.searchreplacement(word)
            result.append(word) if len(prefixString) == 0 else result.append(prefixString)
        return " ".join(result)    
              
    def insert(self,word):
        current = self.root
        for char in word:
            if char not in current.children:
                current.children[char] = TrieNode()  
            current = current.children[char]
        current.is_last = True          

    def searchreplacement(self,word):
        current = self.root
        prefix = ""
        for char in word:
            if char not in current.children:
                return ""
            prefix+=char
            current = current.children[char]
            if current.is_last:
                return prefix
        return prefix        



class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_last = False
        
