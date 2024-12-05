# // Time Complexity :O(M*l) words and their length and dfs
# // Space Complexity :O(M*l) for storing Trie
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : 
# Tried manipulating insert to only accept valid words, but it needed sorting
# Used isEnd is True Logic till len od word was max. Then checked which comes first lexilogically

class TrieNode:
    def __init__(self):
        self.children = {}                      #using {} instead of [None]*26
        self.isEnd = False
class Trie:
    def __init__(self):
        self.root = TrieNode()
        self.longest = ""                       # store value at current node
    
    def insert(self,word:str):                  # Basic insert for {}
        curr = self.root
        for char in word:
            if char not in curr.children:
                curr.children[char] = TrieNode()
            curr = curr.children[char]
        curr.isEnd = True

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()                                   # Create a Trie Node
        for w in words:                                 # load the words in Trie
            trie.insert(w)
        
        longest = ""

        def dfs(curr, word):                            # dfs on trie to find 
            nonlocal longest

            for char,child in curr.children.items():    # key, value in children
                if child.isEnd:
                    new = word + char                   # append word to new word
                    if len(new) > len(longest) or (len(new)== len(longest) and new < longest): # size vs lexi
                        longest = new
                    dfs(child,new)

        dfs(trie.root,"")
        return longest