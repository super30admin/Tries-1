#TC: O(n*l) to build trie and O(28*l) =>O(l) to iterate
#SC: O(n*l)
class Solution:
    class TrieNode:
        def __init__(self):
            self.isEnd = False
            self.children = [None]*26
    
    global output
    def longestWord(self, words: List[str]) -> str:
        self.output = ""
        root = self.TrieNode()
        for word in words:
            curr = root
            for w in word:
                index = ord(w)-ord('a')
                if curr.children[index] is None:
                    curr.children[index] = self.TrieNode()
                curr = curr.children[index]
            curr.isEnd = True
        
        self.DFS(root,"")
        return self.output

    def DFS(self, node, path):
        #base
        if len(path)>len(self.output):
            self.output = path
        #logic 
        for i in range(0,26):
            if node.children[i] and node.children[i].isEnd:
                self.DFS(node.children[i], path+chr(i+ord('a')))