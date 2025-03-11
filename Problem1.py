# Problem 1 : Implement Trie (Prefix Tree)
# Time Complexity : 
'''
L is the length of the word
insert - O(L) 
search - O(L)
startwith- O(L)
'''
# Space Complexity : O(N*L) N- number of words in Trie and L is the length of the word
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
# class for Trie Node
class TrieNode:
    def __init__(self):
        # dictionary for children which will store all possible 26 characters
        self.children = {}
        # boolean variable to end that this is last character of the word
        self.isEnd = False

class Trie:

    def __init__(self):
        # initializing the Trie Node
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        # get a node pointing to root
        node = self.root
        # loop through word
        for char in word:
            # check if the character is not present in the node.children
            if char not in node.children:
                # initialize the node.children[char] with Trie Node
                node.children[char] = TrieNode()
            # increment the node to next node ie. node.children[char]
            node = node.children[char]
        # set the isEnd variable to true for last character
        node.isEnd = True

    def search(self, word: str) -> bool:
        # get a node pointing to root
        node = self.root
        # loop through word
        for char in word:
            # check if character is not present in node.children
            if char not in node.children:
                # return False
                return False
            # increment the node to next node ie. node.children[char]
            node = node.children[char]
        # return value of node.isEnd
        return node.isEnd

    def startsWith(self, prefix: str) -> bool:
        # get a node pointing to root
        node = self.root
        # loop through word
        for char in prefix:
            # check if character is not present in node.children
            if char not in node.children:
                # return False if the char is not present in Trie
                return False
            # increment the node to next node ie. node.children[char]
            node = node.children[char]
        # return True if the prefi is present
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)