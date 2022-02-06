# SC : O(NL)
# TC : O(NL)
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.child = [None]*26    
        

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for char in word:
            if node.child[ord(char) - ord('a')] == None:
                node.child[ord(char) - ord('a')] = TrieNode()
            node = node.child[ord(char) - ord('a')]
        node.isEnd = True
        
class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for word in words:
            trie.insert(word)
        
        self.res = ""
        def dfs(node, path):
            # base
            if len(path) > len(self.res) or (len(path) == len(self.res) and path < self.res):
                x = path[:]
                self.res = x
            
            # logic 
            for i in range(25,-1,-1):
                if node.child[i] and node.child[i].isEnd:
                    # action
                    path = path + chr(ord('a')+i)
                    # recur
                    dfs(node.child[i], path)
                    # remove action
                    path = path[:-1]
        dfs(trie.root, "")
        return self.res
            
            
            
