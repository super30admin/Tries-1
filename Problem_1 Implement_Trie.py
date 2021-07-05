
# Time Complexity :  Insert:O(L)
#                    Search:O(L)
#                    startswith:O(L)
# Space Complexity : Insert:O(L)
#                    Search:O(1)
#                    startswith:O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for i in range(26)]


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        # Start from root
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c) - ord('a')] == None:
                # there is no baby, so insert it
                curr.children[ord(c) - ord('a')] = TrieNode()
            curr = curr.children[ord(c) - ord('a')]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c) - ord('a')] == None:
                return False
            curr = curr.children[ord(c) - ord('a')]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(len(prefix)):
            c = prefix[i]
            if curr.children[ord(c) - ord('a')] == None:
                return False
            curr = curr.children[ord(c) - ord('a')]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)