# Time Complexity : O(m) for both methods
# Space Complexity : O(sum of all words) in the worst case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class TrieNode:
    def __init__(self, char):
        self.char = char
        self.children = [None] * 26
        self.isWord = False
class Trie:

    def __init__(self):
        self.trie = TrieNode('0')
        
    def insert(self, word: str) -> None:
        t = self.trie
        for char in word:
            childIdx = ord(char) - ord('a')
            if not t.children[childIdx]:
                newNode = TrieNode(char)
                t.children[childIdx] = newNode
            
            t = t.children[childIdx]
        t.isWord = True

    def search(self, word: str) -> bool:
        t = self.trie
        for char in word:
            childIdx = ord(char) - ord('a')
            if not t.children[childIdx]:
                return False
            t = t.children[childIdx]
        
        return t.isWord
        

    def startsWith(self, prefix: str) -> bool:
        t = self.trie
        for char in prefix:
            childIdx = ord(char) - ord('a')
            if not t.children[childIdx]:
                return False
            t = t.children[childIdx]
        
        return True