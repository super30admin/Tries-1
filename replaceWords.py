
class Trie:
    def __init__(self):
        self.start = {"*":True}
    
    def addWord(self, word):
        start = self.start
        for letter in word:
            if letter not in start:
                start[letter] = {}
            start = start[letter]
        start["*"] = True
    
    def returnWord(self, word):
        start = self.start
        temp = ""
        if word[0] not in start:
                return temp
        for letter in word:
            temp+=letter
            if letter in start:
                start = start[letter]
                if "*" in start:
                    return temp
            else:
                return ""
        
    
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        myTrie = Trie()
        for word in dictionary:
            myTrie.addWord(word)
        
        arr = sentence.split()
        for index,word in enumerate(arr):
            replaceWord = myTrie.returnWord(word)
            if replaceWord:
                arr[index] = replaceWord
    
        return " ".join(arr) 
    
# Space: O(N)
# Time: O(N)