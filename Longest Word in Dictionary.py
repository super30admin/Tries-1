from collections import deque

class Solution:
    def __init__(self):
        self.root = TrieNode()
        self.root.word = None
        
    def insert(self, word):
        curr = self.root
        for char in word:
            idx = ord(char) - ord('a')
            if not curr.children[idx]:
                curr.children[idx] = TrieNode()
            curr = curr.children[idx]
        curr.word = word
        return
    
    #Solution 1
    def longestWord(self, words: List[str]) -> str:
        #Approach: BFS with trie
        #Time Complexity: n * l     // trie, as well as BFS
        #Space Complexity: n * l    // trie, as well as queue
        #where, n is the number of words, and l is the length of an average word
    
        for word in words:
            self.insert(word)
            
        de = deque()
        de.append(self.root)
        
        while de:
            curr = de.popleft()
            for child in reversed(curr.children):
                if child and child.word:
                    de.append(child)
        
        return curr.word
    
    #Solution 2
    """
    def longestWord(self, words: List[str]) -> str:
        #Approach: DFS with trie
        #Time Complexity: n * l     // trie, as well as DFS
        #Space Complexity: n * l    // trie
        #where, n is the number of words, and l is the length of an average word
        
        for word in words:
            self.insert(word)
            
        self.longestWord = None
        self.maxLen = 0
        
        def dfs(root, level):
            #base
            if not root or (root != self.root and not root.word):
                return
            
            #logic
            if self.maxLen < level:
                self.maxLen = level
                self.longestWord = root.word
            
            for child in root.children:
                dfs(child, level + 1)
        
        dfs(self.root, 0)
        return self.longestWord
    """
        
class TrieNode:
    def __init__(self):
        self.word = None
        self.children = [None for i in range(26)]