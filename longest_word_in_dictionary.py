# N= number of characters in the dictionary

# Time Complexity :DFS: O(N)
# Space Complexity :O(Log N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach




class TrieNode:
    def __init__(self, val) -> None:
        self.val=val
        self.children=[None for i in range(26)]
        self.is_end=False

class Trie:
    def __init__(self) -> None:
        self.root=TrieNode(" ")
    def insert(self, word):
        temp=self.root
        for i in word:
            node=TrieNode(i)
            if(temp.children[ord(i)-ord('a')]==None):
                temp.children[ord(i)-ord('a')]=node
            temp=temp.children[ord(i)-ord('a')]
        temp.is_end=True
    def search(self, word):
        temp=self.root
        for i in word:
            if(temp.children[ord(i)-ord('a')]==None):
                return False
            temp=temp.children[ord(i)-ord('a')]
        return True


class Solution:

    def dfs(self, root, s):
        # base
        if(len(s)>len(self.result)):
            self.result=(s+".")[:-1]
        # logic
        for i in range(26):
            if(root.children[i]!=None and root.children[i].is_end):
                # action
                s+=chr(i+ord('a'))
                # recurse
                self.dfs(root.children[i],s)
                # backtrack
                s=s[:-1]


    def longestWord(self, words: List[str]) -> str:
        self.result=""
        obj=Trie()
        for i in words:
            obj.insert(i)
        s=""
        self.dfs(obj.root, s)
        return self.result


    # Without using Trie
    def longestWord(self, words: List[str]) -> str:
        words=sorted(words)
        w_set=set([""])
        l_word=""
        result=[]
        print(words)
        for i in words:
            if(i[:-1] in w_set):
                w_set.add(i)
                if(len(i)>len(l_word)):
                  
                    l_word=i