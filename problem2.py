#Time O(n*k), space O(n*k)

#Creating TrieNode
class TrieNode:
    def __init__(self):
        self.children={}
        self.word=None
    
class Solution:
   #Initializing trie node 
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self,word):
        cur = self.root
        for i in word:
            if i not in cur.children:
                cur.children[i]=TrieNode()
            cur = cur.children[i]
        cur.word = word
        
    def longestWord(self, words: List[str]) -> str:
        #Create Trie
        for i in words:
            self.insert(i)
        #Apply Bfs
        bfs=deque()
        bfs.append(self.root)
        ans=""
        while bfs:
            cur = bfs.popleft()
            for child in cur.children.values():
                if child.word != None:
                    if len(child.word) > len(ans) or len(child.word) == len(ans) and child.word < ans:
                        ans = child.word
                    bfs.append(child)
        return ans
