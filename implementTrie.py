"""
Time complexity: O(m*n) where M is the length of maximum string in array
Space Complexity: O(m*n) 
Compiled on leetcode: Yes
Difficulties faced: No
"""

class TrieNode:
    def __init__(self, children, isEnd):
        self.val = None
        self.children = children
        self.isEnd = isEnd
        
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode(dict(), False)
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for i in range(len(word)):
            if word[i] not in curr.children:
                curr.children[word[i]] = TrieNode(dict(), False)
            
            if i == len(word) - 1:
                curr.isEnd = True
            else:
                curr = curr.children[word[i]]
         
       
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for i in range(len(word)):
            if word[i] not in curr.children:
                return False
            if i == len(word) - 1:
                return curr.isEnd   
            curr = curr.children[word[i]]
             
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for i in range(len(prefix)):
            if prefix[i] not in curr.children:
                return False
            curr = curr.children[prefix[i]]
        return True    
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)