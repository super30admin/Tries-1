# Time Complexity : O(n) to construct the trie
# Space Complexity : O(n) to construct the trie
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.ch = [0 for _ in range(26)]
        self.end = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str):
        curr = self.root
        for c in word:
            idx = ord(c)-ord('a')
            if not curr.ch[idx]:
                curr.ch[idx] = TrieNode()
            curr = curr.ch[idx]
        curr.end = True

    # Time Complexity : O(n) to construct the trie
    # Space Complexity : O(h) where h is the height of the trie
    def longestWord(self):
        res = ""
        def helper(root, currWord):
            nonlocal res
            if len(currWord) > len(res):
                res = currWord
            for a in range(26):
                if root.ch[a] and root.ch[a].end:
                    helper(root.ch[a], currWord + chr(a + ord('a')))
        helper(self.root, "")
        return res
        

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for w in words:
            trie.insert(w)
        return trie.longestWord()