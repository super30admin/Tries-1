''' Time Complexity : O(L) for every operation where L is length of the word 
    Space Complexity : O(N * L) where N is no of words and L is average length
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : creating TrieNode at each ascii value of char in children array
'''

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for s in word:
            idx = ord(s) - ord('a')
            if curr.children[idx] is None:
                curr.children[idx] = TrieNode()
            curr = curr.children[idx]
        curr.isEnd = True
        

    def search(self, word: str) -> bool:
        curr = self.root
        for s in word:
            idx = ord(s) - ord('a')
            if curr.children[idx] is None:
                return False
            curr = curr.children[idx]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for s in prefix:
            idx = ord(s) - ord('a')
            if curr.children[idx] is None:
                return False
            curr = curr.children[idx]
        return True
            

        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)