"""
Runtime Complexity:
It depends on the length of the word. To insert a word we go over each character and check whether the prefix is already present or not, if not we initialise a treenode. If the word is 
not present then we add all the characters of the word. Same applies for search as well. If we build a trie tree with n word and average 'l' length each then O(n*l)
Space Complexity:
O(1) - because each children are fixed size of 26. If we store 'n' words then O(n*l), where 'l' is the average length of the word.
Yes, the code worked on leetcode.
Issues while coding - No
"""


class TrieNode:
    def __init__(self):
        self.children = [0]*26  #a node has 26 alphabetical children
        self.wordFound = False

class Trie:

    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        curr = self.root
        for char in word:
            c = ord(char) - ord('a')
            if not curr.children[c]:
                curr.children[c] = TrieNode()   #if char is not present, initialise a children with received char.
                curr.children[c].val  = char
            curr = curr.children[c]
        curr.wordFound = True       #when the word is done, we set a marker as true

    def search(self, word: str) -> bool:
        curr = self.root
        for char in word:
            c = ord(char) - ord('a')
            if not curr.children[c]:      #if any of the char in the word is missing we directly return false
                return False
            curr = curr.children[c]
        return curr.wordFound
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for char in prefix:
            c = ord(char) - ord('a')
            if not curr.children[c]:
                return False
            curr = curr.children[c]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)