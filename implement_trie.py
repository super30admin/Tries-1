# Time Complexity : O(N) where M is size of matrix and L is length of target word
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I use a hashmap to store the children at each level of trie and if the level is at the end of the word then
# we store is end = True

class TrieNode:
    def __init__(self):
        self.children = [None for x in range(26)]
        self.is_end = False
    
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
        for l in word:
            index = ord(l) - ord("a")
            if not current.children[index]:
                current.children[index] = TrieNode()
            current = current.children[index]
        current.is_end = True 

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        current = self.root
        for l in word:
            index = ord(l) - ord("a")
            if not current.children[index]:
                return False
            current = current.children[index]
        if current.is_end == True:
            return True

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        current = self.root
        for l in prefix:
            index = ord(l) - ord("a")
            if not current.children[index]:
                return False
            current = current.children[index]   
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)