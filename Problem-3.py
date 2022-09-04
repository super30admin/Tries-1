# 208. Implement Trie (Prefix Tree)

'''
Leetcode all test cases passed: Yes
class Trie:
    n is length of word
    def insert(self, word: str)
        Time Complexity: O(n) 
        Space Complexity: O(1)
    def isRoot(self, word):
        Time Complexity: O(n) 
        Space Complexity: O(1)

Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
      m is length of dictionary
      g is length of sentence
      k is average length of the word in dictionary
      l is average length of the word in sentence
      
      Time Complexity: O(m + g) 
      Space Complexity: O(k + l)
'''
from collections import defaultdict
class Trie:

    def __init__(self):
        self.children = defaultdict(Trie)
        self.end = False

    def insert(self, word: str) -> None:
        curr = self
        for ch in word:
            curr = curr.children[ch]
        curr.end = True

    def isRoot(self, word) :
        curr = self
        index = 0
        for ch in word:
            
            if ch in curr.children:
                
                curr = curr.children[ch]
                
            else:
                return False
            if curr.end:
                    return word[:index + 1] 
            index += 1
        return False
    
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        t = Trie()
        for d in dictionary:
             t.insert(d)
        
        s = ""
        
        for word in sentence.split():
            temp = t.isRoot(word)
            #print(word,temp)
            if temp != False:
                s+= temp
            else:
                s+= word
            s += " "
        return s[:-1]
