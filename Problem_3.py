# // Time Complexity : O(n * l + m * k)
# // Space Complexity : O(n * l)

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self,word):
        temp = self.root
        for i in word:
            idx = ord(i) - 97
            if(temp.children[idx] is None):
                temp.children[idx] = TrieNode()
            temp = temp.children[idx]
        temp.isEnd = True
    
    def findroot(self, word):
        ans = ""
        temp = self.root
        for i in word:
            idx = ord(i) - 97
            
            if(temp.children[idx] is None):
                return word
            else:
                ans = ans+i
            temp = temp.children[idx]
            if(temp.isEnd):
                return ans
        
        return word

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for i in dictionary:
            trie.insert(i)
            
        sentenceArray = sentence.split(" ")
        for i in range(len(sentenceArray)):
            
            sentenceArray[i] = trie.findroot(sentenceArray[i])
        return (" ".join(sentenceArray))
            
