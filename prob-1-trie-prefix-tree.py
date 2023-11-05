class TrieNode:
    def __init__(self, char=""):
        """
        Using dictionary instead of an array list to store the adjacent nodes a.k.a children
        """
        self.char = char
        self.children = {}
        self.is_end = False

class Trie:
    """
  
		Time Complexity: O(n) - where n is the length of the string
    Space Complexity: O(n) - where n is the length of the string
    Did this code successfully run on Leetcode: Yes
    
    Any problem you faced while coding this: No
    """

    def __init__(self):
        """
        Initialize root
        """
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        """
        Insert word into the trie
        """
        node = self.root
        for char in word:
            if char in node.children:
                node = node.children[char]
            else:
                node.children[char] = TrieNode(char)
                node = node.children[char]
        node.is_end = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie
        """
        node = self.search_prefix(word)
        return (node and node.is_end)


    def startsWith(self, prefix: str) -> bool:
        """
        Does any word in the Trie start with the given prefix 
        """
        node = self.search_prefix(prefix)
        return node
        

    def search_prefix(self, prefix: str) -> TrieNode or None:
        """
        Return the last TrieNode of the prefix, if found, or return None, if not found
        """
        node = self.root # start with root
        for char in prefix:
            if char not in node.children:
                return None
            else:
                node = node.children[char]
        
        return node

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

