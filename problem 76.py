# Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)


# Time Complexity : O(n)
# Space Complexity : O(m * n) - insertion, O(1) - search and startswith
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : NO


class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        curr =  self.root
        for i in range(len(word)):
            ch = word[i]
            index = ord(ch)-ord('a')
            if (curr.children[index] == None):
                curr.children[index] = TrieNode()
            
            curr = curr.children[index] 
        
        curr.isEnd = True
        

    def search(self, word: str) -> bool:
        curr =  self.root
        for i in range(len(word)):
            ch = word[i]
            index = ord(ch)-ord('a')
            if (curr.children[index] == None):
                return False
            curr = curr.children[index] 
        
        return curr.isEnd        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(len(prefix)):
            ch = prefix[i]        
            index = ord(ch) - ord('a')
            if curr.children[index] == None:
                return False
            curr = curr.children[index]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)