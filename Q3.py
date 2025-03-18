############# Replace Word

# Time Complexity :  Insert -> O(n), getLongest -> O(n)
# Space Complexity : O(26*h) where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Using a trie add all the dictionary elements to a trie. When going through the sentence replace the word wiith the matching portion


class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        curr = self.root
        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        curr.is_end = True
    
    def search(self, word):
        curr = self.root
        result = ""
        for c in word:
            if c not in curr.children:
                break
            result += c
            curr = curr.children[c]
            if curr.is_end:
                return result
        return word

class Solution:
    def replaceWords(self, dictionary, sentence):
        my_trie = Trie()
        for word in dictionary:
            my_trie.insert(word)
        
        result = []
        for word in sentence.split():
            result.append(my_trie.search(word))
        
        return " ".join(result)
