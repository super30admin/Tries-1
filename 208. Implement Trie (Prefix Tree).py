# Question: Implement a trie(i.e. a prefix-tree) with insert, search, and startsWith methods.

# At first we create a TrieNode class which will have an array of size 26 to store the children and a boolean variable to know where a particular word ends.
# The we initialize the root of the Trie as an empty TrieNode.
# For the insert method we will iterate through the characters of the word and for each character we will check if the corresponding child node is null or not. If it is null then we will create a new TrieNode and move to that node. After the loop we will mark the last node as the end of the word.
# For the search method we will iterate through the characters of the word and for each character we will check if the corresponding child node is null or not. If it is null then we will return false. After the loop we will check if the last node is the end of the word or not. If it is then we will return true else we will return false.
# For the startsWith method we will iterate through the characters of the prefix and for each character we will check if the corresponding child node is null or not. If it is null then we will return false. After the loop we will return true as we have found the prefix in the Trie.

class Trie:
    class TrieNode:
        def __init__(self):
            self.children = [None] * 26
            self.isEnd = False

    def __init__(self):
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        # Time: O(L) => Length of the word
        # Space: O(L) => Length of the word
        curr = self.root
        for i in range(len(word)):
            char = word[i]
            char_idx = ord(char) - ord('a')
            if curr.children[char_idx] == None:
                curr.children[char_idx] = self.TrieNode()
            curr = curr.children[char_idx]
        # Here curr will be at the last idx
        curr.isEnd = True

    def search(self, word: str) -> bool:
        # Time: O(L) => Length of the word
        # Space: O(1)
        curr = self.root
        for i in range(len(word)):
            char = word[i]
            char_idx = ord(char) - ord('a')
            if curr.children[char_idx] == None: return False
            curr = curr.children[char_idx]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        # Time: O(L) => Length of the prefix
        # Space: O(1)
        curr = self.root
        for i in range(len(prefix)):
            char = prefix[i]
            char_idx = ord(char) - ord('a')
            if curr.children[char_idx] == None: return False
            curr = curr.children[char_idx]
        return True