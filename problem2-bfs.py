from collections import deque
class TrieNode:
    def __init__(self):
        self.word = ""
        self.child = [False for _ in range(26)]


class Solution:
    
    def __init__(self):
            self.root = TrieNode()
            
    def insert(self, word):

        curr = self.root
        for i in range(len(word)):
            idx = ord(word[i]) - ord("a")
            if not curr.child[idx]:
                curr.child[idx] = TrieNode()
            curr = curr.child[idx]
        curr.word = word 
        
        
    def longestWord(self, words: List[str]) -> str:
        
        for word in words:
            self.insert(word)
        
        q = deque()
        
        q.append(self.root)
        
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for j in range(25, -1, -1):
                    if curr.child[j] and curr.child[j].word:
                        q.append(curr.child[j])
                        
                        
        return curr.word
                        
#Time complexity and Space complexity O(NL) N -> size of input L -> average length of word                        
                        
                        
                        
                
        
            
                