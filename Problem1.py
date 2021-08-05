# 208. Implement Trie (Prefix Tree)

# Time Complexity: O(n)
# Space Complexity: O()
# Did this code successfully run on Leetcode: all test cases passed
# Any problem you faced while coding this: No

# Approach: 

class Trie:
    
    class TrieNode:
        
        def __init__(self):
            self.isEnd = False
            self.children = [None] * 26

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        # Traverse the entire word character by character 
        
        for s in list(word):
            if curr.children[ord(s)-ord('a')] == None:
                curr.children[ord(s)-ord('a')] = self.TrieNode()
            
            curr = curr.children[ord(s)-ord('a')]
            
        curr.isEnd = True 
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        # Traverse the entire word character by character 
        
        for s in list(word):
            if curr.children[ord(s)-ord('a')] == None:
                return False
            
            curr = curr.children[ord(s)-ord('a')]
            
        if curr.isEnd == True:
            return True
        
        return False
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        
        curr = self.root
        # Traverse the entire word character by character 
        
        for s in list(prefix):
            if curr.children[ord(s)-ord('a')] == None:
                return False
            
            curr = curr.children[ord(s)-ord('a')]
             
        return True
        
# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)