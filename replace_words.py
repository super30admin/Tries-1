# Time Complexity : O(k*N) where k is averange length of the word in the sentence and N is number of words in the sentence
# Space Complexity : O(k * N) where k is averange length of the word and N is number of words in the dictionary
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.children = {} 
        self.isEnd = False

class Solution:
    def __init__(self):
        self.root = TrieNode()
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        curr = self.root
        result = []
        for word in dictionary:
            self.insertDictWords(word)
        
        words = sentence.split(' ')
        
        for word in words:
            result.append(self.getReplacementWord(word))
            
        return " ".join(result)
        
    def getReplacementWord(self, word):
        curr = self.root
        
        for i,l in enumerate(word):
            if l not in curr.children:
                break
            else:
                curr = curr.children[l]
                if curr.isEnd == True:
                    return word[:i+1]
        
        return word

        
    
    def insertDictWords(self, word):
        curr = self.root
        
        for l in word:
            if l not in curr.children:
                curr.children[l] = TrieNode()
            curr = curr.children[l]
        
        curr.isEnd = True