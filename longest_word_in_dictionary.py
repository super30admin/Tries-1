# O(L) TIME AND O(L) SPACE WHERE L IS LENGTH OF LONGEST WORD
class Solution:
    def __init__(self):
        self.longest_word = ""
        self.root = {}
     
    def longestWord(self, words: List[str]) -> str:
        for word in words:
            self.insert(word)
        
        for word in words:
            self.explore(word)
        
        return self.longest_word
    
    def insert(self,word):
        current = self.root
        for char in word:
            if char not in current:
                current[char] = {}
            current = current[char]
        current["*"] = True
    
    def explore(self,word):
        current = self.root
        for char in word:
            if "*" not in current[char]:
                return
            current = current[char]
        
        if len(word) == len(self.longest_word):
            self.longest_word = min(self.longest_word,word)
        
        elif len(word) > len(self.longest_word):
            self.longest_word = word