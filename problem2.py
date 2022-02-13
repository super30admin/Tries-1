#Time Complexity O(length of words)
#Space Complexity O(length of words)

class TrieNode:
    def __init__(self,char=""):
        self.char = char
        self.children={}
        self.end=0
        

class Trie:

    def __init__(self):
        self.root = TrieNode('0')
        self.words=[]
        
    def insert(self, word,ind):
        node = self.root
        
        for char in word:
            if char in node.children:
                node = node.children[char]
            else:
                new_node = TrieNode(char)
                node.children[char] = new_node
                node = new_node
        node.end= ind

    def dfs(self):
        ans= ""
        stack = []
        stack.append(self.root)
        while len(stack)>0:
            node = stack.pop()
            if node.end >0 or node == self.root:
                if node !=self.root:
                    word = self.words[node.end-1]
                    if len(word) > len(ans) or len(word) == len(ans) and word != ans:
                        ans = word
                for nei in node.children.values():
                    stack.append(nei)
                            
                            
        return ans
        
        
    
class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        ind = 0
        for word in words:
            ind+=1
            trie.insert(word,ind)
        
        trie.words = words
        
        return trie.dfs()
        
