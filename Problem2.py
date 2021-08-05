# 720. Longest Word in Dictionary

# Time Complexity : Inserting word in Trie - O(nl), nl log(nl)
# Space Complexity : 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : all test cases passed.

# Approach: Trie + Sort and Search

class Solution:
    
    class TrieNode:
        
        def __init__(self):
            self.isEnd = False
            self.children = [None] * 26
            
    def __init__(self):
        self.root = self.TrieNode()
    
    
    def longestWord(self, words: List[str]) -> str:
        
        # first insert all the words in Trie
        
        for w in words:
            
            self.insert(w)
        
        # sort words by the length of the characters 
        # lexicographical order is reversed
        
       # words = sorted(words, key=len, reverse=True)
        
        words.sort(key=lambda item: (-len(item), item))
        
        
        # search all the longest words which can be built character by character
        
        max_len = 0
        result = ""
        print(words)
        for w in words:
            
            if self.search(w):
                if max_len < len(w):
                    result = w
                    max_len = len(w)

        return result
    
    def insert(self, word:str):
        
        curr = self.root
        for s in list(word):
            if curr.children[ord(s)-ord('a')] == None:
                curr.children[ord(s)-ord('a')] = self.TrieNode()
            curr = curr.children[ord(s)-ord('a')]
        curr.isEnd = True
    
    def search(self, word:str) -> bool:
        
        # search if for every character if there isEnd = true
        
        curr = self.root
        for s in list(word):
            if curr.children[ord(s)-ord('a')] == None or curr.children[ord(s)-ord('a')].isEnd == False:
                return False
            
            curr = curr.children[ord(s)-ord('a')]
        return True

# 720. Longest Word in Dictionary

# Time Complexity : Inserting word in Trie - O(nl)
# Space Complexity : 
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : 56/59 test cases passed

# Approach: Trie + Backtracking - removing the last character after dfs

class Solution:
    
    class TrieNode:
        
        def __init__(self):
            self.isEnd = False
            self.children = [None] * 26
            
    def __init__(self):
        self.root = self.TrieNode()
        self.max_len = 0
        self.result = ""
    
    def insert(self, word:str):
        
        curr = self.root
        for s in list(word):
            if curr.children[ord(s)-ord('a')] == None:
                curr.children[ord(s)-ord('a')] = self.TrieNode()
            curr = curr.children[ord(s)-ord('a')]
        curr.isEnd = True
    
    def longestWord(self, words: List[str]) -> str:
        
        for w in words:
            self.insert(w)
            
        self.search(self.root, 0, "")
        return self.result
        
    def search(self, curr, length, result):
        
        # base case
        
        if curr.children:
            if self.max_len < length:
                self.max_len = length
                self.result = result
                print(length, result)
        
        # logic case
        
        for idx,char in enumerate(curr.children):
            if char is not None and char.isEnd is True:
                result = result + chr(idx+97)
                self.search(char, length+1, result)
                result = result.rstrip(result[-1])
         
# 720. Longest Word in Dictionary

# Time Complexity : Inserting word in Trie - O(nl), 
# Space Complexity : 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : All test cases passed

# Approach: Using Tries + BFS using Queue

class Solution:
    
    class TrieNode:
        
        def __init__(self):
            self.word = ""
            self.children = [None] * 26
            
    def __init__(self):
        self.root = self.TrieNode()
        self.max_len = 0
        self.result = ""
    
    def insert(self, word:str):
        
        curr = self.root
        for s in list(word):
            if curr.children[ord(s)-ord('a')] == None:
                curr.children[ord(s)-ord('a')] = self.TrieNode()
            curr = curr.children[ord(s)-ord('a')]
        curr.word = word
        
    def longestWord(self, words: List[str]) -> str:
        
        # insert all the words in the dictionary
        
        for w in words:
            self.insert(w)
        
        q = []
        q.append(self.root)
        
        while(q):
            # pop the node and loop over the children and add to the queue if isEnd is True
            node = q.pop(0)
            idx = 25
            while(idx>=0):
                if node.children[idx]!=None and node.children[idx].word!= "":
                    q.append(node.children[idx])
                idx-=1
        return node.word
    
        
        
                
            
        