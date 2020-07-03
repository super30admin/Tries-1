# Time Complexity : O(n) n = length of word
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Trie:
    def __init__(self):
        self.childrens = [False] * 26 
        self.word = ''
class TrieNode():
    def __init__(self):
        self.root = Trie()
    
    def insert(self,word):
        node = self.root
        for ch in word:
            indx = ord(ch) - ord('a')
            if node.childrens[indx] == False:
                node.childrens[indx] = Trie()
            node = node.childrens[indx]
        node.word = word
        
class Solution:
    def longestWord(self, words: List[str]) -> str:
        t = TrieNode()
        for word in words:
            t.insert(word)
        node = t.root
        print(node.childrens[0].word)
        q = [node]
        curr = None 
        while q:
            curr = q.pop(0)
            for i in range(25,-1,-1):
                if curr.childrens[i] and curr.childrens[i].word:
                    q.append(curr.childrens[i])
        return curr.word
            
            

