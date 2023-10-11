# Time Complexity: O(nl) where n is number of words and l is avg length of the word
#  Space Complexity:  O(l).
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

class Trie:
    

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            if curr.children[ord(ch) - ord("a")] == None:
                curr.children[ord(ch) - ord("a")] = TrieNode()
            curr = curr.children[ord(ch) - ord("a")]
        curr.isEnd = True
        

    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            if curr.children[ord(ch) - ord("a")] == None:
                return False
            curr = curr.children[ord(ch) - ord("a")]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(len(prefix)):
            ch = prefix[i]
            if curr.children[ord(ch) - ord("a")] == None:
                return False
            curr = curr.children[ord(ch) - ord("a")]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
