#// Time Complexity : O(L) where L is length of the word
# // Space Complexity : O(n * L) where n is number of words and l is average length of the word
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.

class TrieNode:
    def __init__(self):
        # Stores children nodes and whether node is the end of a word
        self.children = [None for _ in range(26)]
        self.isEnd = False

class Trie:
    def __init__(self):
      self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in word:
            if curr.children[ord(i) - ord('a')] == None:
                curr.children[ord(i) - ord('a')] = TrieNode()
            curr = curr.children[ord(i) - ord('a')]
        curr.isEnd = True
            
    def search(self, word: str) -> bool:
        curr = self.root
        for i in word:
            if curr.children[ord(i)-ord('a')] == None:
                return False
            curr = curr.children[ord(i)-ord('a')]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in prefix:
            if curr.children[ord(i)-ord('a')] == None:
                return False
            curr = curr.children[ord(i)-ord('a')]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

# Approach:
# 1.  We create a TrieNode class to represent each node in the Trie. Each node has
# a list of children nodes and a boolean flag to indicate whether the node is the end of a
# word.
# 2.  We create a Trie class with methods to insert words, search for words, and check
# if a prefix exists in the Trie.
# 3.  In the insert method, we iterate over each character in the word and create a new
# node if the character is not already in the Trie. We then move to the child node
# 4.  In the search method, we iterate over each character in the word and check if the
# character exists in the Trie. If it does not exist, we return False. If we reach the
# end of the word, we return True.
# 5.  In the startsWith method, we iterate over each character in the prefix and check if
# the character exists in the Trie. If it does not exist, we return False. If we reach
# the end of the prefix, we return True.
