# Time Copmlexity : O(N * L)    N = number of words L = length of longest word
# Space Complexity : O(N * L) 

class TrieNode:
    isEnd = False
    children = []
    
    def __init__(self):
        self.isEnd = False
        self.children = [None]*26
    
    
class Trie:
    max_word = ""
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
    
    def search(self, word: str):
        curr = self.root
        len_count = 0
        for i in range(0, len(word)):
            ch = word[i]
            pos = ord(ch) - ord('a')
            
            if curr.children[pos] == None:
                return None
                
            curr = curr.children[pos]
            if curr.isEnd == True: #checking count of isEnd so taht it can be compared with len(word)
                len_count += 1
            
        if len_count == len(word) and len(word) > len(self.max_word):
            self.max_word = word
    
class Solution:
    def longestWord(self, words: List[str]) -> str:
        words.sort()

        tr = Trie()
        for i in words: 
            tr.insert(i)
        
        for i in words: 
            tr.search(i)
        
        return (tr.max_word)