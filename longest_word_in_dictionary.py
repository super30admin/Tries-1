# Time Complexity: O(nl) where n is number of words and l is avg length of the word
#  Space Complexity:  O(l).
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26
        self.ch = None


class Trie:
    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        curr = self.root
        for i in word:
            if curr.children[ord(i) - ord('a')] == None:
                curr.children[ord(i) - ord('a')] = TrieNode()
            curr =  curr.children[ord(i) - ord('a')]
            curr.ch = i
        curr.isEnd = True

class Solution:
    def longestWord(self, words: List[str]) -> str:
        self.result = ""
        self.trie = Trie()
        for word in words:
            self.trie.insert(word)

        self.helper(self.trie.root, "")
        return self.result
    
    def helper(self, root, curr):
        for i in range(25, -1, -1):
            trie_child = root.children[i]
            if root.children[i] != None:
                if root.children[i].isEnd:
                    curr = curr + root.children[i].ch
                    if len(curr) >= len(self.result):
                        self.result = str(curr)
                    self.helper(root.children[i], curr)
                    curr = curr[:-1]
