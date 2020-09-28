# Time Complexity : O(n) for all three functions
# Space Complexity : O(m), where m is the number of characters
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
#1. Create a trienode having arrays as children; each child array is of length 26(to hold 26 chars as the problem says lowercase only)
#2. Insert a link to character in children array if the character doesn't exist, else create another children array
#3. Maintain a boolean flag isWord which sets to True once a complete word is inserted in the TrieNode
#4. Return word for searched word if input array goes out of bounds and the isWord flag is set to true, else return false

class Trie:
    
    class TrieNode():
        def __init__(self):
            self.children = [None for _ in range(26)]
            self.isWord = False
    
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
        
        for i in word:
            ch = ord(i) - ord('a')
            if curr.children[ch] == None:
                curr.children[ch] = self.TrieNode()  
            curr = curr.children[ch]
        
        curr.isWord = True
       

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        
        for i in word:
            ch = ord(i) - ord('a')
            
            if curr.children[ch] == None:
                return False
            curr = curr.children[ch]
        
        return curr.isWord
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        
        for i in prefix:
            ch = ord(i) - ord('a')
            
            if curr.children[ch] == None:
                return False
            curr = curr.children[ch]
        
        return True
        
        
# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)