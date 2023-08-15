#Time Complexity :O(n*l)
#Space Complexity :O(n*l)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

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
        for word in words:
            self.insertTrie(root,word)

        self.dfs(root,[])
        return self.result

    def dfs(self, curr, path):
        if len(self.result)<len(path):
            self.result="".join(path)
            print(self.result)

        for i in range(26):
            if curr.childeren[i]!=None and curr.childeren[i].isEnd:
                length=len(path)
                path+=(chr(i+ord('a')))
                self.dfs(curr.childeren[i],path)
                del(path[-1])

        


