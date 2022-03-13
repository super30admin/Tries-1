# Time Complexity: O(Length of word)
# Space Complexity: O(Length of word)
# Did this run successfully on Leetcode: Yes
# Any problems faced while coding: syntax issues
# Explain your approach: Implemented a trie using map within map, each TrieNode has an array of 26 child TrieNodes
# and a boolean to check if we've reached end of word, isEnd, 
# to insert a word, we check if each character in word is present, wherever not present, we add a new Trienode there, 
# else, if present, we move to next character of word
# to search, if any character of word not present in root, return false, else, move to next char of word, 
# in the end return the value of the boolean isEnd
# for prefix, similar to search, just that in the end we return True

class TrieNode:

    def __init__(self):
        self.children = {}
        self.isEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            if (ord(c) - ord('a')) not in curr.children:
                curr.children[ord(c) - ord('a')] = TrieNode()
            curr = curr.children[ord(c) - ord('a')]
        curr.isEnd = True
        

    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            if (ord(c) - ord('a')) not in curr.children:
                return False
            curr = curr.children[ord(c) - ord('a')]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(len(prefix)):
            c = prefix[i]
            if (ord(c) - ord('a')) not in curr.children:
                return False
            curr = curr.children[ord(c) - ord('a')]
        return True


            
    
