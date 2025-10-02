# Time Complexity : O(L) where L is the length of the words
# Space Complexity : O(N.L) where N is the number of words and L is the length of the words
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am first creating a TrieNode class which has an array of size 26 to store the children nodes and a boolean variable to mark the end of a word.
# I am then creating a Trie class which has a root node of type TrieNode.
# The init function initializes the root node.
# The insert function takes a word as input and inserts it into the trie. In such a way that each character of the word is a child node of the previous character.
# I walk through each character of the word and check if it is already present in the children array of the current node. 
# If it is not present, I create a new TrieNode and add it to the children array.
# I then move to the child node and repeat the process for the next character.
# Finally, I mark the end of the word by setting the EndOfWord variable to True.
# The longestWord function takes a list of words as input and finds the longest word in the trie such that all its prefixes are also present in the trie.
# I first insert all the words into the trie using the insert function.
# I then use a depth first search (dfs) approach to traverse the trie and find the longest word.
# The dfs function takes the current node and the current path as input.
# If the length of the current path is greater than the length of the result, I update the result.
# I then iterate through the children array of the current node and check if the child node is not None and if it is the end of a word.
# If it is, I append the character to the current path and call the dfs function recursively with the child node and the updated path.
# After the recursive call, I backtrack by removing the last character from the current path.
# Finally, I return the result.

from typing import List
class TrieNode():
    def __init__(self):
        self.children = [None] * 26
        self.endOfWord = False
class Solution:
    def __init__(self):
      self.root = TrieNode()
      self.result = ""
    def insert(self, word: str) -> None:
        node = self.root
        for i in word:
            # if i in node:
            index = ord(i) - ord('a')
            if not node.children[index]:
                node.children[index] = TrieNode()
            node = node.children[index]
        node.endOfWord = True
    def longestWord(self, words: List[str]) -> str:
        for w in words:
            self.insert(w)
        
        def dfs(curr,path):
            if len(path) > len(self.result):
                self.result = "".join(path)
            for i in range(26):
                if curr.children[i] and curr.children[i].endOfWord:
                    length = len(path)
                    path.append(chr(i + ord('a')))
                    dfs(curr.children[i],path)
                    path = path[:length]
        dfs(self.root,[])
        return self.result



        
        