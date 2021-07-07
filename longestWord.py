# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

class Solution:
    def __init__(self):
        self.root = TrieNode()
        
    def longestWord(self, words: List[str]) -> str:
        for word in words:
            self.insert(word)
            
        queue = []
        queue.append(self.root)
        while queue:
            size = len(queue)
            for i in range(size):
                node = queue.pop(0)
                for j in range(25,-1,-1):
                    if node.children[j] is not None and node.children[j].string is not None:
                        queue.append(node.children[j])
        return node.string
    
    def insert(self, word):
        node = self.root
        for i in range(len(word)):
            if node.children[ord(word[i]) - ord('a')] is None:
                node.children[ord(word[i]) - ord('a')] = TrieNode()
            node = node.children[ord(word[i]) - ord('a')]
        node.string = word
    
    
class TrieNode:
    def __init__(self):
        self.children = [None for _ in range(26)]
        self.string = None