# Using BFS Approach
# Time Complexity: O(nl) where n is number of words and l is avg length of dictionary
# Space Complexity: O(nl) where n is number of words and l is avg length of dictionary
class TrieNode:
    def __init__(self):
        self.word = None
        self.children = [None] * 26

        
class Solution:
        
    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            index = ord(word[i]) - ord('a')
            if curr.children[index] == None:
                curr.children[index] = TrieNode()
            curr = curr.children[index]
        curr.word = word

        
    def longestWord(self, words: List[str]) -> str:
        self.root = TrieNode()
        for word in words:
            self.insert(word)  
            
        q = deque()
        q.append(self.root)
        curr = self.root 
        while len(q) != 0:
            curr = q.popleft()
            for i in range(25,-1,-1):
                if curr.children[i] != None and curr.children[i].word != None:
                    q.append(curr.children[i])
                    
        if curr.word == None:
            return ''
        return curr.word


# Storing required string in separate queue
class TrieNode:
    def __init__(self):
        self.c = ''
        self.isEnd = False
        self.children = [None] * 26

        
class Solution:
        
    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            index = ord(word[i]) - ord('a')
            if curr.children[index] == None:
                curr.children[index] = TrieNode()
                curr.children[index].c = word[i]
            curr = curr.children[index]
        curr.isEnd = True

        
    def longestWord(self, words: List[str]) -> str:
        self.root = TrieNode()
        for word in words:
            self.insert(word)  
            
        q = deque()
        s = deque()
        q.append(self.root)
        s.append('')
        curr = self.root 
        while len(q) != 0:
            curr = q.popleft()
            sb = s.popleft()
            for i in range(25,-1,-1):
                if curr.children[i] != None and curr.children[i].isEnd != False:
                    q.append(curr.children[i])
                    newsb = sb
                    newsb += curr.children[i].c
                    s.append(newsb)
                    
        return sb


# DFS Approach
class TrieNode:
    def __init__(self):
        self.string = None
        self.children = [None] * 26
        
class Solution:
    def __init__(self):
        self.root = TrieNode()
        self.result = ""
    
    def insert(self, word):
        curr = self.root
        for i in range(len(word)):
            index = ord(word[i]) - ord('a')
            if curr.children[index] == None:
                curr.children[index] = TrieNode()
            curr = curr.children[index]
        curr.string = word

    def longestWord(self, words: List[str]) -> str:
        for word in words:
            self.insert(word)
        self.dfs(self.root)
        return self.result
    
    def dfs(self, root):   
        for i in range(len(root.children)):
            if root.children[i] != None and root.children[i].string != None:
                self.dfs(root.children[i])
                
            elif i == len(root.children) - 1:
#                 edge case if none of children of root is present in given word list
                if root.string == None:
                    return self.result
#                 check if obtained new string is greater than result, or if its equal check their lexicographic order
                elif len(root.string) > len(self.result) or (len(self.result) == len(root.string) and self.result > root.string):
                    self.result = root.string
                

    