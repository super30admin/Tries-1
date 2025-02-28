# Time Complexity : 
#   insert() -> O(l) 
#   search() -> O(l)
#   startsWith() -> O(l)

# Space Complexity : O(n*l)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isWord = False

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        cur = self.root
        for c in word:
            key = ord(c) - ord("a")
            if cur.children[key]:
                cur = cur.children[key]
            else:
                node = TrieNode()
                cur.children[key] = node
                cur = cur.children[key]
        cur.isWord = True
        

    def search(self, word: str) -> bool:
        cur = self.root
        for c in word:
            key = ord(c) - ord("a")
            if cur.children[key]:
                cur = cur.children[key]
            else:
                return False
        
        return cur.isWord

    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        for c in prefix:
            key = ord(c) - ord("a")
            if cur.children[key]:
                cur = cur.children[key]
            else:
                return False

        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)