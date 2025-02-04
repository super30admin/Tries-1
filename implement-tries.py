class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False
class Trie:

    def __init__(self):
        self.root = TrieNode()
#Time Complexity : O(n)
#Space Complexity : O(n)

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            i = ord(c) - ord("a")
            if curr.children[i] == None: 
                curr.children[i] = TrieNode()
            curr = curr.children[i]
        curr.isEnd = True
#Time Complexity : O(n), where n is the length of the word
#Space Complexity : O(1)

    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            i = ord(c) - ord("a")
            if curr.children[i] == None:
                return False
            curr = curr.children[i]
        return curr.isEnd
#Time Complexity : O(n) where n is the length of the prefix
#Space Complexity : O(1)

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            i = ord(c) - ord("a")
            if curr.children[i] == None:
                return False
            curr = curr.children[i]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)