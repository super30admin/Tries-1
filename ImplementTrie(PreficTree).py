"""
Time Complexity : O(L) where L is the length of the word
Space Complexity : O(L) where L is the length of the word
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class TrieNode:
    def __init__(self, char=""):
        self.char = char
        self.children = {}
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
        TC : O(L) where L is length of the word
        SC : O(nk) where n is no. of words k is length of each word
        """
        curr = self.root
        for char in word:
            if char not in curr.children:
                newNode = TrieNode(char)
                curr.children[char] = newNode
                curr = newNode
            else:
                curr = curr.children[char]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        TC: O(L) where L is length of the word
        SC : O(1) 
        """
        curr = self.root
        for char in word:
            if char not in curr.children:
                return False
            else:
                curr = curr.children[char]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        TC: O(L) where L is length of the word
        SC : O(1)
        """
        curr = self.root
        for char in prefix:
            if char not in curr.children:
                return False
            else:
                curr = curr.children[char]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)