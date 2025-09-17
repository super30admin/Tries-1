#  Time Complexity : O(L) for insert, search and startsWith where L is the length of the word
#  Space Complexity : O(N * L) -> where N is the number of words and L is the length of the words
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code implements a Trie (prefix tree) data structure that stores strings efficiently for prefix-based queries. The insert method adds a word character by character, creating new TrieNodes as needed, and marks the last node as the end of a word. The search method checks if a full word exists in the Trie, while startsWith verifies if any word in the Trie begins with a given prefix.

class Trie:
    class TrieNode:
        def __init__(self):
            self.children = {}
            self.isEnd = False

    def __init__(self):
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            if curr.children.get(c) is None:
                curr.children[c] = self.TrieNode()
            curr = curr.children[c]
        curr.isEnd = True    

    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            if curr.children.get(c) is None:
                return False
            curr = curr.children[c]
        return curr.isEnd
        
    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            if curr.children.get(c) is None:
                return False
            curr = curr.children[c]
        return True