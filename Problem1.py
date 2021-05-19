## Problem1 
# Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)

class TrieNode:
    def __init__(self, letter = None):
        self.children = {}
        self.isEnd = False
        
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.trie = TrieNode()
        
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        head = self.trie
        for letter in word:
            if letter not in head.children: 
                head.children[letter] = TrieNode(letter)
            head = head.children[letter]
        head.isEnd = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        head = self.trie
        for letter in word:
            if letter not in head.children:
                return False
            head = head.children[letter]
        return head.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        head = self.trie
        for letter in prefix:
            if letter not in head.children:
                return False
            head = head.children[letter]
        return True
        
#Time Complexity: o(nk) n - number of words k - avg length of the longest word
#Space Complexity: O(nk)
#Approach: Implement a trie data structure. For insertion traverse through the word, check the list if it has matching letters and if the end of the word is reached, insert a boolena charecter in the end to indicate that the entire word has been inserted. Serach process is also similar but it will return true only if it encounters a true boolean value at the end of the string. 
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)