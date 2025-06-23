# Time Complexity: O(W) W total character across all words
# Space Complexity: O(W)
class TrieNode:
    def __init__(self, val):
        self.val = val
        self.children = [None] * 26
        self.isword = False

class Trie:
    def __init__(self):
        self.root = TrieNode(" ")

    def insert(self, word: str) -> None:
        temp = self.root
        for i in word:
            idx = ord(i) - ord('a')
            if temp.children[idx] is None:
                temp.children[idx] = TrieNode(i)
            temp = temp.children[idx]
        temp.isword = True

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for word in words:
            trie.insert(word)
        
        self.longest = ""
        self.dfs(trie.root, "")
        return self.longest

    def dfs(self, node, path):
        # Base condition: if not root and not a word, return
        if node != None and node.val != " " and not node.isword:
            return

        if len(path) > len(self.longest) or (len(path) == len(self.longest) and path < self.longest):
            self.longest = path

        for i in range(26):
            child = node.children[i]
            if child is not None:
                self.dfs(child, path + child.val)

