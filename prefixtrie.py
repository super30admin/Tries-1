# // Time Complexity :O(L)L is the length of the string
# // Space Complexity :O(m*k)where m is the number of words and k is the av length of word
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




class TrieNode:
    def __init__(self):
        self.isEnd=False
        self.children=[False for i in range(26)]
        
class Trie:

    def __init__(self):
        self.root=TrieNode()
        

    def insert(self, word: str) -> None:
        curr=self.root
        for i in range(len(word)):
            c=word[i]
            if not curr.children[ord(c)-ord('a')]:
                curr.children[ord(c)-ord('a')]=TrieNode()
            curr=curr.children[ord(c)-ord('a')]
        curr.isEnd=True
            
                
            
        

    def search(self, word: str) -> bool:
        curr=self.root
        for i in range(len(word)):
            c=word[i]
            if not curr.children[ord(c)-ord('a')]:
                return False
            curr=curr.children[ord(c)-ord('a')]
        return curr.isEnd
            
        
        

    def startsWith(self, prefix: str) -> bool:
        curr=self.root
        for i in range(len(prefix)):
            c=prefix[i]
            if not curr.children[ord(c)-ord('a')]:
                return False
            curr=curr.children[ord(c)-ord('a')]
        return True
                
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)