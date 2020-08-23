#Time Complexity - O(n*m) for forming the Trie where n is the number of words and m is the longest word
#Space Complexity - O(max(n*m,m*m))  for  the Trie where n is the number of words and m is the longest word. In m*m, the first m is the stack
# of DFS and second m is for the  path I pass to helper at each depth. 
#Works on leetcode  - yes
#Approach - We first insert all words in Trie and perform DFS on the root node. The DFS is recursive function which checks both the length
# and lexographical order for equal lengths. 
class TrieNode:
    def __init__(self):
        self.children = collections.defaultdict(TrieNode)
        self.isEnd = False
        
class Trie:
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self,word):
        cur = self.root
        for w in word:
            #if w not in cur.children:
                #cur.children[w] = TrieNode
            cur = cur.children[w]
        cur.isEnd = True
    
    def dfs(self):
        def helper(node, path):
            res = path
            for c,child in node.children.items():
                if child.isEnd:
                    temp = helper(child, path+c)
                    if len(temp)>len(res):
                        res = temp
                    elif len(temp)==len(res) and temp<res:
                        res=temp
            return res
        return helper(self.root, '')
            
        
class Solution:
    def longestWord(self, words: List[str]) -> str:
        T = Trie()
        for w in words:
            T.insert(w)
        return T.dfs()
        