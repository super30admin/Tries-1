"""
208. Implement Trie (Prefix Tree)


Successfully excecuted on leetcode


Approach:
1. Insert - Search childrent of current node. If link exists, add the new character in children. If link does not exist, create new children
2. Search - From the root, iterate character by character. At each step compare the character and at the end check if self.end flag is True
3. startsWith -  From the root, iterate character by character. If all the characters in prefix exist in Trie in same order return True. No need to check self.end flag in this case.

"""

class TreeNode:
# Initialize your data structure here.
    def __init__(self,v):
        self.val = v
        self.children = defaultdict()
        self.end = False

class Trie:

    def __init__(self):
        self.root = TreeNode(None)

    def insert(self, word): # Time = O(mn),space = O(mn) where m = length of word, n = total number if words 
        parent = self.root
        print("parent", parent.val)
        for i,char in enumerate(word):
            if char not in parent.children:
                parent.children[char] = TreeNode(char)
            parent = parent.children[char]
            if i == len(word)-1:
                parent.end = True

    def search(self, word): # Time = O(m), space = O(1) where m = length of word
        parent = self.root
        for char in word:
            #print("children", parent.children)
            if char not in parent.children:
                return False
            parent = parent.children[char]            
        return parent.end

    def startsWith(self, prefix):# Time = O(m), space = O(1) where m = length of prefix
        parent = self.root
        for char in prefix:
            if char not in parent.children:
                return False
            parent = parent.children[char]
          
        return True