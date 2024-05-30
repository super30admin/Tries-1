# Time Complexity : O(L)
# Space Complexity : O(nk)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False
class Trie:

    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            if curr.children[ord(c)-ord('a')] is None:
                curr.children[ord(c)-ord('a')] = TrieNode()
            curr = curr.children[ord(c)-ord('a')]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            if curr.children[ord(c)-ord('a')] is None:
                return False
            curr = curr.children[ord(c)-ord('a')]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            if curr.children[ord(c)-ord('a')] is None:
                return False
            curr = curr.children[ord(c)-ord('a')]
        return True