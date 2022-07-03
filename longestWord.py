"""
Approach: Use the Trie Data Structure to store all the words and then explore each path using DFS and backtracking to see what is the longest complete word can be formed.
TC: O(maxlen(word)) Meaning at the worst case we will have to explore the longest path that is the longest word in the dictionary. And if most of the words are of equal length and unique characters, it will be N*avg_len(words)
SC: O(Sum(len(all of words))) to build the trie.
"""
class TrieNode:
    def __init__(self):
        self.is_end = False
        self.children = [None]*26

class Trie:
    def __init__(self):
        self.root = TrieNode()
        self.root.is_end = True
        
    def insert(self, word):
        curr = self.root
        for char in word:
            idx = ord(char)-ord('a')
            if curr.children[idx] == None:
                curr.children[idx] = TrieNode()
            curr = curr.children[idx]
        curr.is_end = True
        
class Solution:
    def __init__(self):
         self.result = ""
            
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for word in words:
            trie.insert(word)
        def dfs_backtrack(trieNode, string):
            # base case is not needed as for loop recursion doesn't continue if node 
            # if None of it is not the end node
            
            # logic
            for idx,child in enumerate(trieNode.children):
                if child and child.is_end:
                    # action
                    string += chr(idx+ord('a'))
                    # recurse
                    dfs_backtrack(child, string)
                    # backtrack
                    string = string[:-1]
            
            if len(self.result) == len(string):
                self.result = min(self.result,string)
            elif len(self.result) < len(string):
                self.result = string

            
        dfs_backtrack(trie.root, "")
        return self.result