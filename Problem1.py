#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.isEnd=False
        self.children=[None]*(26)

class Trie:

    def __init__(self):
        self.root=TrieNode() 

    #Time Complexity :O(n)
    #Space Complexity :O(n)
    def insert(self, word: str) -> None:
        curr=self.root
        for i in range(len(word)):
            char=word[i]
            idx=ord(char)-ord('a')
            if not curr.children[idx]:
                curr.children[idx]=TrieNode()
            curr=curr.children[idx]
        curr.isEnd=True
        
    #Time Complexity :O(n)
    #Space Complexity :O(1)
    def search(self, word: str) -> bool:
        curr=self.root
        for i in range(len(word)):
            char=word[i]
            idx=ord(char)-ord('a')
            if not curr.children[idx]:
                return False
            curr=curr.children[idx]
        return curr.isEnd

    #Time Complexity :O(n)
    #Space Complexity :O(1)
    def startsWith(self, prefix: str) -> bool:
        curr=self.root
        for i in range(len(prefix)):
            char=prefix[i]
            idx=ord(char)-ord('a')
            if not curr.children[idx]:
                return False
            curr=curr.children[idx]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)