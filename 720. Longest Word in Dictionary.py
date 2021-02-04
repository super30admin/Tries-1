# // Time Complexity : O(mn)
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
	# Maintain a trie node with the character and the end of the word is marked by the word attribute which will hold
	# the entire word.
	# Apply BFS starting from the root and iterate from the reverse 
from collections import deque
class TrieNode:
    def __init__(self):
        self.word = None
        self.children = [None] * 26

class Solution:
    def insertWord(self,word):
        CurrNode = self.root
        for i in word:
            if CurrNode.children[ord(i) - ord('a')] == None:
                CurrNode.children[ord(i) - ord('a')] = TrieNode()
            CurrNode = CurrNode.children[ord(i) - ord('a')]
        CurrNode.word = word
        
    def longestWord(self, words: List[str]) -> str:
        if not words:
            return ''
        self.root  = TrieNode()
        for w in words:
            self.insertWord(w)
            
        Queue = deque()
        curr = self.root
        Queue.append(curr)
        while(len(Queue) != 0):
            Currnode = Queue.popleft()
            for new in range(25,-1,-1):
                if Currnode.children[new] != None and Currnode.children[new].word != None:
                    Queue.append(Currnode.children[new])
        return Currnode.word