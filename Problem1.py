# Did this code successfully run on Leetcode : Yes

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = {}
        
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        
#   Time Complexity: O(n) (where n is length of word)
#   Space Complexity: O(n) (where n is length of word)
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
#       Iterating over every character of the word
        for char in word:
#           If current character is not in the children dictionary, we create new TrieNode and assign it.
            if char not in curr.children:
                curr.children[char] = TrieNode()
#           If current character is in the children dictionary we just go to next TrieNode.
            curr = curr.children[char]
        curr.isEnd = True

#   Time Complexity: O(n) (where n is length of word)
#   Space Complexity: O(1) (not storing anything for searching)
    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
#       Iterating over every character of the word
        for char in word:
#           If character is not found in current TrieNode's children than return false otherwise iterate over next TrieNode
            if char not in curr.children:
                return False
            curr = curr.children[char]
#       Even if all the charcters of word is in the trie but if it is not the end of word return false. because given word can be prefix of some another word.
        return curr.isEnd
    
#   Time Complexity: O(n) (where n is length of word)
#   Space Complexity: O(1) (not storing anything for startswith)
    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
#       Iterating over every character of the prefix
        for char in prefix:
#           If character is not found in current TrieNode's children than return false otherwise iterate over next TrieNode
            if char not in curr.children:
                return False
            curr = curr.children[char]
#       If we reach at the last character of prefix that means prefix exists in the Trie so return True.
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
