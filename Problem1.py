'''

Time Complexity : O(L)
Space Complexity : O(L)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

For the insert operation, using a list to store the element at it's index.
Similarly to check for the word, we look the isEnd flag

'''


class TrieNode:
    def __init__(self):
        self.child = [None] * 26
        self.IsEnd = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        cur = self.root

        for c in word:
            if not cur.child[ord(c)-ord('a')]:
                cur.child[ord(c)-ord('a')] = TrieNode()
            cur = cur.child[ord(c)-ord('a')]

        cur.IsEnd = True

    def search(self, word: str) -> bool:
        cur = self.root

        for c in word:
            if not cur.child[ord(c)-ord('a')]:
                return False
            cur = cur.child[ord(c)-ord('a')]

        return cur.IsEnd

    def startsWith(self, prefix: str) -> bool:
        cur = self.root

        for c in prefix:
            if not cur.child[ord(c)-ord('a')]:
                return False
            cur = cur.child[ord(c)-ord('a')]

        return True



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)