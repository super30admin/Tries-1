# Time: O(M * N + K * P) where M and N are the word length and number of words in dic and K is the total words in senstence with length p
# Space: O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False
    
class Solution:
    def insert(self, word):    
        current = self.root
        for w in word:
            if current.children[ord(w) - ord('a')] == None:
                current.children[ord(w) - ord('a')] = TrieNode()
            current = current.children[ord(w) - ord('a')]
            
        current.isEnd = True 
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
         #Base case
        if not dictionary or len(dictionary) == 0:
            return sentence
        
        self.root = TrieNode()
        
        for word in dictionary:
            self.insert(word)
            
        sentence_split = sentence.split() # split the word into spaces
        result = []
        
        # creating a space for the result array
        for i in range(len(sentence_split)):
            word = sentence_split[i]
            if i > 0:
                result.append(" ")
             
            current = self.root
            replacement = []
            
            for c in (word):
                if current.children[ord(c) - ord('a')] == None or current.isEnd: #current.isEnd is true
                    break
                replacement.append(c)
                current = current.children[ord(c) - ord('a')]
                
            if current.isEnd:
                result.append("".join(replacement)) #if word is found we will replace it.
            else:
                result.append(word) #  if current.children[ord(c) - ord('a')] == None then replace original letter
                    
        return "".join(result)
