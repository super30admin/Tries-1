# Time Complexity: O(N*L)+ O(M*L) 
# Space Complexity: O(N*L) + O(M*L)
# Does this code run on Leetcode: Yes
# Any problems faced while coding this: No

from typing import List


class TrieNode:
    def __init__(self, val):
        self.val = val
        self.children = [None] * 26
        self.isword = False

class Trie:
    def __init__(self):
        self.root = TrieNode(" ") 
    
    def getRoot(self):
        return self.root
    
    def insert(self, word):
        temp = self.root
        for i in word:
            idx = ord(i) - ord('a')
            if not temp.children[idx]:
                temp.children[idx] = TrieNode(i)
            temp = temp.children[idx]
        temp.isword = True

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:  
            trie.insert(word)
        
        root = trie.getRoot()
        res = []
        words = sentence.split()
        
        for word in words:
            temp = root
            replace_str = ""
            found_shorter_root = False
            
            for char in word:
                idx = ord(char) - ord('a')
                replace_str += char
                
                if not temp.children[idx]:
                    break
                
                temp = temp.children[idx]
                if temp.isword:
                    found_shorter_root = True
                    break  
            
            if found_shorter_root:
                res.append(replace_str)
            else:
                res.append(word)
        
        return " ".join(res)