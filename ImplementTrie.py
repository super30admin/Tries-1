# Time Complexity : O(L) for insert, search, and startsWith, where L is the length of the word
# Space Complexity : O(N * L) where N is number of words and L is average word length (due to storing nodes in the Trie).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We create each Trie node with a 26-sized array for all lowercase letters.
# While inserting or searching, we index using c - 'a' to navigate the array.
# The isEnd flag helps us check if it's an exact word or just a path prefix.

class Trie:

    class TrieNode:
        def __init__(self):
            self.children = [None]*26
            self.isEnd = False

    def __init__(self):
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if curr.children[idx] is None:
                curr.children[idx] = self.TrieNode()
            curr = curr.children[idx]
        curr.isEnd = True
        
    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if curr.children[idx] is None:
                return False

            curr = curr.children[idx]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            idx = ord(c) - ord('a')
            if curr.children[idx] is None:
                return False
            curr = curr.children[idx]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)