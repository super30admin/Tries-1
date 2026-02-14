#-------Solition : Trie + DFS
''' Time Complexity : O(N * L) where N is the number of words in dictionary, 
                                    L is average length of words
    Space Complexity : O(N * L) : 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''
class TrieNode:
    def __init__(self):
        self.children = [None] * 26 
        self.isEnd = False

class Solution:
    def longestWord(self, words: List[str]) -> str:
        path = []
        self.res = ""
        self.maxlen = float("-inf")
        root = TrieNode()
        for word in words:
            curr = root
            for w in word:
                c = ord(w) - ord('a')
                if curr.children[c] is None:
                    curr.children[c] = TrieNode()
                curr = curr.children[c]
            curr.isEnd = True
        
        def dfs(node,path):
            if len(path) > self.maxlen:
                self.maxlen = len(path)
                self.res = ("".join(path))

            for i in range(26):
                if node.children[i] is not None and node.children[i].isEnd:
                    charAt = chr(i+ord('a'))
                    path.append(charAt)
                    dfs(node.children[i],path)
                    path.pop()

        dfs(root,path)
        return self.res



        

        