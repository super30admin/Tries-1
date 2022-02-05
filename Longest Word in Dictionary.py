# Time Complexity :
# TC: O(nl) --> 2nl (one for creating trie and one for searching)

# Space Complexity :
# SC: O(nl) --> nl(trie) + (nl/2)(queue)

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach

class Solution:
    
    # BFS + Tries
    # TC: O(nl) --> 2nl
    # SC: O(nl) --> nl(trie) + (nl/2)(queue)
    
    class TrieNode:
        
        def __init__(self):
            self.children = [None for i in range(26)]
            self.isEnd = False
            self.char = ""
            self.word = ""
            
    root = TrieNode()
    
    def insert(self, word):
        curr = self.root
        
        for char in word:
            if curr.children[ord(char) - ord('a')] == None:
                curr.children[ord(char) - ord('a')] = self.TrieNode()
                curr.children[ord(char) - ord('a')].char = char
                curr.children[ord(char) - ord('a')].word = curr.word+char
                
            curr = curr.children[ord(char) - ord('a')]
            
        curr.isEnd = True
                
                
            
    def longestWord(self, words: List[str]) -> str:
        
        self.root = self.TrieNode()
        
        for word in words:
            self.insert(word)
            
        import queue
        q = queue.Queue()
        q.put(self.root)
        
        while (not q.empty()):
            
            curr = q.get()
                
            for i in range(25, -1, -1):
                if (curr.children[i] != None) and (curr.children[i].isEnd):
                    q.put(curr.children[i])
                    
        return curr.word