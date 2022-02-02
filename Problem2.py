# // Time Complexity : O(nl) where n is the length of the dictionary and l is the average length of a word.
# // Space Complexity : O(nl) where n is the length of the dictionary and l is the average length of a word.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

class Node:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26
        self.ch = None

class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in word:
            if curr.children[ord(i) - ord('a')] == None:
                curr.children[ord(i) - ord('a')] = Node()
            curr = curr.children[ord(i) - ord('a')]
            curr.ch = i
        curr.isEnd = True

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        self.result = ""
        for word in words:
            trie.insert(word)
        self.dfs(trie.root,"")
        return self.result
    
    def dfs(self,root,path):
        #base
        if len(path) >= len(self.result):
            self.result = path[:]
        
        #logic
        for i in range(25,-1,-1):
            if root.children[i] != None and root.children[i].isEnd == True:
                path += root.children[i].ch
                self.dfs(root.children[i],path)
                path = path[:-1]
