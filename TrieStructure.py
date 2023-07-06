# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to recurse choose and not choose path then if the target is met return the list if not increment the index till it reaches the end of list

class TrieNode:
    def __init__(self):
        self.children={}
        self.IsEnd=False
        
class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in word:
            if (i not in curr.children):
                curr.children[i]=TrieNode()    
            curr=curr.children[i]
        curr.IsEnd=True

    def search(self, word: str) -> bool:
        curr = self.root
        for i in word:
            if (i not in curr.children):
                return False
            curr=curr.children[i]
        return curr.IsEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in prefix:
            if (i not in curr.children):
                return False
            curr=curr.children[i]
        return True