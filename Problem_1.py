class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [0] * 26

class Trie:
        
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            index = ord(word[i]) - ord('a')
            if not curr.children[index]:
                curr.children[index] = TrieNode()
            curr = curr.children[index]
        curr.isEnd = True    

    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(len(word)):
            index = ord(word[i]) - ord('a')
            if not curr.children[index]:
                return False
            curr = curr.children[index]
        return curr.isEnd
        
    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(len(prefix)):
            index = ord(prefix[i]) - ord('a')
            if not curr.children[index]:
                return False
            curr = curr.children[index]
        return True
        
# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

# Time Complexity:
# Insert: O(L)
# Search: O(L)

# Space Complexity:
# Insert: O(L)
# Search: O(1)

