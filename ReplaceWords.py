'''
Solution:
1.  Insert all new possible words to the Trie.
2.  Maintain a queue which adds words (Trie Nodes) at each level.
3.  Return the last popped element from the Queue as the maximum length word.
Time Complexity:    O(n * L)    n is no. of words and L is max length of one word
Space Complexity:   O(n * L)    max space occupied by the Trie
--- Passed all testcases on Leetcode successfully
'''


class TrieNode():
    
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False 
        self.ch = None

class Trie():
    root = None
    def __init__(self):    
        self.root = TrieNode() 
    
    def insert(self, word):
        curr = self.root
        for c in word:
            index = ord(c) - ord('a')
            if not curr.children[index] :
                curr.children[index] = TrieNode()
            
            curr = curr.children[index] 
            curr.ch = c
        curr.isEnd = True
    
class Solution:
    
    result = ""
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        self.result = ""
        for word in words:
            trie.insert(word)
        
    
        self.backtrack(trie.root, "")
        return self.result
    
    
    def backtrack(self, root, path):
        # base
        if(len(path) >= len(self.result)):
            self.result = path
            
        # logic
        length = len(path)
        for i in range(25,-1,-1):
            if root.children[i] != None and root.children[i].isEnd:
                # action
                path += root.children[i].ch
                # recurse
                self.backtrack(root.children[i], path)
                # backtrack
                path = path[:length]
             
            
            
        
        


# // Your code here along with comments explaining your approach

class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False      

class Solution:  
    root = TrieNode()
    def __init__(self):
        self.root = TrieNode()
            
    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            index = ord(c) - ord('a')
            if not curr.children[index] :
                curr.children[index] = TrieNode()
            
            curr = curr.children[index] 
        curr.isEnd = True
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        for word in dictionary:
            self.insert(word)
        
        splitList = sentence.split(' ')
        result  = ""
        flag = 0 #to avoid repetiion of first word
        for word in splitList:
            #adding space before second word onwards 
            if word  != splitList[0] or flag:
                result  += " "
            flag = 1
            replacement = ""
            curr = TrieNode()
            curr = self.root
            for letter in word:
                index = ord(letter) - ord('a')
                if not curr.children[index] or curr.isEnd:
                    break
                    
                curr = curr.children[index]
                replacement += letter
            
            if curr.isEnd:
                result += replacement
            else:
                result +=word
            
        return result
                
            
            
            
            