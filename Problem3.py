# Time Complexity : O(nk)
# Space Complexity : O(nk)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#Tries + DFS
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.Childs = [None]*26
        
class Solution:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        self.longest = []
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.root
        
        for i in range(len(word)):
            if node.Childs[ord(word[i]) - 97] == None:
                node.Childs[ord(word[i]) - 97] = TrieNode()
            node = node.Childs[ord(word[i]) - 97]
        node.isEnd = True
        return;
    def longestWord(self, words: List[str]) -> str:
        for word in words:
            self.insert(word)    
        self.helper(self.root,[])
        return "".join(self.longest)
    
    def helper(self,root,path):
        
        # base
        if root == None:
            return
        #logic
        if root == self.root:
            for i in range(len(root.Childs)):
                if root.Childs[i] != None:
                    path.append(str(chr(i+97)))
                    self.helper(root.Childs[i],path)
                    path.pop()
        elif root.isEnd:
            if len(self.longest) < len(path):
                self.longest = path.copy()
            for i in range(len(root.Childs)):
                if root.Childs[i] != None:
                    path.append(str(chr(i+97)))
                    self.helper(root.Childs[i],path)
                    path.pop()
    
        