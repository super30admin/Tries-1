# Runs on Leetcode
    # Runtime - O(m*n) where m is # of words and n is length of longest word
    # Memory - O(# of words)
    
class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None]*26
            self.string = None
            
    def __init__(self):
        self.root = self.TrieNode()
        
    def insert(self,word):
        node = self.root
        for i in word:
            if not node.children[ord(i)-ord('a')]:
                node.children[ord(i)-ord('a')] = self.TrieNode()
            node = node.children[ord(i)-ord('a')]
        node.string = word
        
    def longestWord(self, words: List[str]) -> str:
        for i in words:
            self.insert(i)
        queue = []
        queue.append(self.root)
        
        while queue:
            size = len(queue)
            for i in range(size):
                node = queue.pop(0)
                for j in range(25,-1,-1):
                    if node.children[j] and node.children[j].string:
                        queue.append(node.children[j])
                    else:
                        continue
        return node.string
