# Leetcode problem link : https://leetcode.com/problems/palindrome-partitioning/
# Time Complexity:    O(n)
# Space Complexity:   O(m) no of all the characters present in Trie
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
    1. Create a class with TrieNode with size 26 for all the lowercase characters. All the positions in thsi array will then contain a pointer to another TrieNode.
    2. Every word is stored as each character in next level of TrieNode list with root containing the first characters.
    3. For searching we start with root and looks for the character in each level. The boolean flag in each node signifies if the word ends at that point or not.
    
'''

class Trie:
    class TrieNode:
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
        for w in word:
            if curr.children[ord(w) - ord('a')] == None:
                curr.children[ord(w) - ord('a')] = self.TrieNode()
            curr = curr.children[ord(w) - ord('a')]
        
        curr.isWord = True
            
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for w in word:
            if curr.children[ord(w) - ord('a')] == None:
                return False
            curr = curr.children[ord(w) - ord('a')]
        
        return curr.isWord

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for w in prefix:
            if curr.children[ord(w) - ord('a')] == None:
                return False
            curr = curr.children[ord(w) - ord('a')]
        
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)