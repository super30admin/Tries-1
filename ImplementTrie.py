#Time Complexity: O(L)
#Space Complexity: O(L)
#Successfully ran on leetcode

class Trie:
    class TrieNode:
        def __init__(self):
            self.isEnd = False
            self.children = [None]*26
    def __init__(self):
        self.root = self.TrieNode()
    def insert(self, word: str) -> None:
        curr = self.root
        for i in word:
            if not curr.children[ord(i)-ord('a')]:
                curr.children[ord(i)-ord('a')] = self.TrieNode()
            curr = curr.children[ord(i)-ord('a')]
        curr.isEnd = True
    def search(self, word: str) -> bool:
        curr = self.root
        for i in word:
            if not curr.children[ord(i)-ord('a')]:
                return False
            curr = curr.children[ord(i)-ord('a')]
        return curr.isEnd
    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in prefix:
            if not curr.children[ord(i)-ord('a')]:
                return False
            curr = curr.children[ord(i)-ord('a')]
        return True