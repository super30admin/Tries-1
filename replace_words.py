# O(L) TIME WHERE L IS LEN(LONGEST WORD) IN SENTENCE AND O(N) SPACE WHERE N IS LEN(SENTENCE)
class Solution:
    def __init__(self):
        self.root = {}
        self.replace_words = []
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
            self.insert(word)
        
        sentence_list = sentence.split(" ")
        
        for word in sentence_list:
            self.replace(word)
        
        return ' '.join(self.replace_words)
                
    def insert(self,word):
        current = self.root
        for char in word:
            if char not in current:
                current[char] = {}
            current = current[char]
        current["*"] = word
    
    def replace(self,word):
        current = self.root
        for char in word:
            if char not in current:
                break
            if "*" in current[char]:
                self.replace_words.append(current[char]["*"])
                return
            current = current[char]
        
        self.replace_words.append(word)