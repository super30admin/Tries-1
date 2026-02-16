# // Time Complexity : O(n * l)
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
   
class Solution:
    
    ans = ""

    def findLongest(self,trie, curr):
 
        if(len(curr) > len(self.ans)):
            self.ans = curr
        for i in range(26):
          
            if(trie.children[i] is not None):
                if(trie.children[i].isEnd):
                    self.findLongest(trie.children[i],curr+chr(i+97))
                    

    def longestWord(self, words: List[str]) -> str:

        trie = Trie()
        for word in words:
            trie.insert(word)
        self.findLongest(trie.root,"")
        return self.ans