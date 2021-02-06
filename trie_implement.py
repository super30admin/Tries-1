"""
Description: Implement a Trie

Time Complexicity: O(n)
Space Complexicity: O(n)
where n is the length of a given word (string)

Approach:
1. TrieNode
- Create a new treenode with default list of 26 items (all None to start, number of lower letters), and isEnd
- isEnd is the stopping point for any given word (subword)
2. Use TrieNode
+ for insert, start with current node as root
  - traverse the current with each character, if character is not found at a given index -> add a TrieNode
  - in each step update current to the created or available TrieNode for the current character
+ for search and startswith a prefix
  - traverse the current with each character, if character is not found at a given index -> return False
  - in each step update the current to the available TrieNode for the current character
  - at the end return .isEnd (for search, may be True or False) and return True for startsWith (prefix)
"""

class TrieNode:
    
    def __init__(self):
        
        self.children = [None] * 26
        self.isEnd = False

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        currNode = self.root
        for i, char in enumerate(word):
            if currNode.children[ord(char) - ord("a")] == None:
                currNode.children[ord(char) - ord("a")] = TrieNode()
            currNode = currNode.children[ord(char) - ord("a")]
        
        currNode.isEnd = True
    
    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        currNode = self.root
        for i, char in enumerate(word):
            if currNode.children[ord(char) - ord("a")] == None: return False
            currNode = currNode.children[ord(char) - ord("a")]
            
        return currNode.isEnd

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        currNode = self.root
        for i, char in enumerate(prefix):
            if currNode.children[ord(char) - ord("a")] == None: return False
            currNode = currNode.children[ord(char) - ord("a")]
            
        return True  
        
# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
