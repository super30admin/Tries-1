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
# The search function takes a word as input and searches for it in the trie.
# I walk through each character of the word and check if it is present in the children array of the current node.
# If it is not present, I return False.
# If it is present, I move to the child node and repeat the process for the next character.
# Finally, I return the value of the EndOfWord variable of the last node.
# The startsWith function takes a prefix as input and checks if there is any word in the trie that starts with the given prefix.
# I walk through each character of the prefix and check if it is present in the children array of the current node.
# If it is not present, I return False.
# If it is present, I move to the child node and repeat the process for the next character.
# Finally, I return True if I have traversed all the characters of the prefix.


class TrieNode():
    def __init__(self):
        self.arr = [None] * 26
        self.EndOfWord= False

class Trie:
    def __init__(self):
      self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for i in word:
            # if i in node:
            index = ord(i) - ord('a')
            if not node.arr[index]:
                node.arr[index] = TrieNode()
            node = node.arr[index]
        node.EndOfWord = True

    def search(self, word: str) -> bool:
        node = self.root
        for i in word:
            index = ord(i) - ord('a')
            if not node.arr[index]:
                return False
            node = node.arr[index]
        return node.EndOfWord
            
    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for i in prefix:
            index = ord(i) - ord('a')
            if not node.arr[index]:
                return False
            node=node.arr[index]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)