# TC: O(w) where w is word length for each operation
# SC: O(w) where w is word length for insert operation, O(1) for search and startsWith
# LeetCode: Y(https://leetcode.com/problems/implement-trie-prefix-tree)
# Approach: In Trie data structure, each character is stored in a hierarchical tree structure
#           The presence of each node in a hierarchy indicated presence of that character in the hierarchy.
#           app and apple are stored as a
#                                        \
#                                         p
#                                          \
#                                           p (is_last_char = True)
#                                          /
#                                         l
#                                        /
#                                       e (is_last_char = True)

class TrieNode:
    def __init__(self):
        self.is_last_char = False
        self.children = {}

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
        current = self.root
        for character in word:
            if character not in current.children:
                current.children[character] = TrieNode()
            current = current.children[character]
            
        current.is_last_char = True
        
       
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        
        current = self.root
        for character in word:
            if character not in current.children:
                return False
            current = current.children[character]
            
        return current.is_last_char
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        current = self.root
        for character in prefix:
            if character not in current.children:
                return False
            current = current.children[character]
            
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
