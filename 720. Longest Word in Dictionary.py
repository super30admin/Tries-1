class TrieNode:
    #prefix tree
    #each root node has 1)boolean value to indicate end or not 2) children map >here 26 lowercase alphas
        # Initialize your data structure here.
        def __init__(self):
            #self.c=c
            self.index=0
            self.children={}
    
class Trie:
        def __init__(self):
            self.root = TrieNode()
    
        # @param {string} word
        # @return {void}
        # Inserts a word into the trie.
        
        def insert(self, word,index):
            #initilize node as root trieNode
            node=self.root
            #for every char in word> check if entry is there in children map> if not>create one and insert and proceed with that child
            for c in word:
                if c not  in node.children:
                    node.children[c]=TrieNode()
                node=node.children[c]
            #mark end
            node.index=index
            #print(node.index)
           
        
        def dfs(self,words):
            #O(26)>stack elements
            stack=[]
            res=''
            stack.append(self.root)
            while stack:
                node=stack.pop()
                #start with root or when endword exists in a node
                if node==self.root or node.index>0:
                    #if not root
                    if node!=self.root:
                       #fetch particular word
                        word = words[node.index - 1]
                        #1)if len of word is greater then for sure count it in res
                        #2)if len of word is equal to res then check alpha order as well (apple>apply)
                        if len(word)>len(res) or (len(word)==len(res) and res>word):
                            res=word
                    #append all child nodes to stack
                    for i in node.children.values():
                        stack.append(i)
            return res
            
       
            
class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        if not words:
            return ''
        trie = Trie()
        for i,w in enumerate(words): 
            #O(n)
            #for every word, run insert function
            trie.insert(w,i+1) #O(length of word)
            
        return(trie.dfs(words))
    #O(N*length of word) both time and space