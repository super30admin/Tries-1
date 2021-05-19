from collections import defaultdict

## Problem3
# Replace Words (https://leetcode.com/problems/replace-words/)

class Trie:
    
    def __init__(self):
        self.root = defaultdict(dict) 
        self.root["is_end"] = False 
        
    def insert(self, word):
        
        root = self.root
        for char in word:
            if not char in root:
                root[char] = defaultdict(dict)
            root = root[char]
        root["is_end"] = True 
    
    def get_prefix(self, word):
        
        prefix = ""
        root = self.root
        
        for char in word:
            if char in root :
                # if char is found, add it to prefix
                prefix += char
                root = root[char]
                if root["is_end"] == True:
                    return prefix
            else:
                break
        return word

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        trie = Trie()
        for root in dictionary:
            trie.insert(root) 
        
        res = []
        for word in sentence.split(" "):
            res.append(trie.get_prefix(word)) 
        
        return " ".join(res)
    
#Time Complexity: O(mn) + O(KL) m - number of words, n - avg number of characters => [dictionary] K = nums of words L = avg length of word => [sentence] 
#Space Complexity: O(mn) 
#Approach: Using Trie data structure. Put the dictionary in the trie and when sentence is being processed, check with the trie and if we reach the isend boolean variable to be true then return that word else return just the sentence. 
        