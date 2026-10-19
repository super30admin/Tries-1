# Time Complexity : O(L) Length of the word
# Space Complexity :
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Implementing Trie

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        currentNode = self.root
        for i in range(len(word)):
            ch = word[i]
            if ch not in currentNode.children:
                currentNode.children[ch] = TrieNode()
            currentNode = currentNode.children[ch]
        currentNode.isEnd = True

    def search(self, word: str) -> bool:
        currentNode = self.root
        for i in range(len(word)):
            ch = word[i]
            if ch not in currentNode.children:
                return False
            currentNode = currentNode.children[ch]
        return currentNode.isEnd

    def startsWith(self, prefix: str) -> bool:
        currentNode = self.root
        for i in range(len(prefix)):
            ch = prefix[i]
            if ch not in currentNode.children:
                return False
            currentNode = currentNode.children[ch]
        return True


