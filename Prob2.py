#Time Complexity :O(n*l)
#Space Complexity :O(n*l)

# Insert all words in the Trie. Then use DFS to search for the longest word. Here, use backtracking since we need the actual word (path of DFS). 
# In DFS, we go ahead only if curr.children[i] exists and curr.children[i].Eow is True.
# Each time len(previous longest)<len(curr word) update it

class TrieNode:
    def __init__(self):
        self.childeren=[None]*26
        self.isEnd=False

class Solution:
    def insertTrie(self,root, word):
        curr=root
        for i in range(len(word)):
            c=word[i]
            idx=ord(c)-ord('a')
            if not curr.childeren[idx]:
                curr.childeren[idx]=TrieNode()
            curr=curr.childeren[idx]
        curr.isEnd=True

    result=""
    def longestWord(self, words: List[str]) -> str:
        root=TrieNode()
        for word in words:  #n*l
            self.insertTrie(root,word) #insert all words using Trie

        self.dfs(root,[]) #then use DFS to get the longest word. 
        return self.result

    def dfs(self, curr, path): #n*l
        if len(self.result)<len(path): #here, if len is same, we need lexicographically inferior word, this is taken care in the line 36 for loop, as we check from 0-26 -> a to z. 
        # Each time len(previous longest)<len(curr word) update it
            self.result="".join(path)
            print(self.result)

        for i in range(26): #here, if len is same, we need lexicographically inferior word, this is taken care in the line 36 for loop, as we check from 0-26 -> a to z. 
            if curr.childeren[i]!=None and curr.childeren[i].isEnd: 
                
                #ACTION
                path+=(chr(i+ord('a')))
                #RECURSE
                self.dfs(curr.childeren[i],path)
                #BACKTRACK
                path.pop()

        

