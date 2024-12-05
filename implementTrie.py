# // Time Complexity :O(m) for prefix search, insert and delete
# // Space Complexity :O(m*l) for word and length
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.children = [None] *26  # 26 size hashet at every elvel
        self.isEnd = False          # if an active word 

class Trie:

    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word: str) -> None:
        curr = self.root
        for char in word:
            i = ord(char) - ord('a')           
            if not curr.children[i]:
                curr.children[i] = TrieNode()       # create a trieNode
            curr = curr.children[i]                 # next
        curr.isEnd = True 

    def search(self, word: str) -> bool:            # search for the word in TrieNode
        curr = self.root
        for char in word:
            i = ord(char) - ord('a')          
            if not curr.children[i]:
                return False
            curr = curr.children[i]
        return curr.isEnd
        
    def startsWith(self, prefix: str) -> bool:
        curr = self.root        
        for char in prefix:
            i = ord(char) - ord('a')
            if not curr.children[i]:
                return False
            curr = curr.children[i]
        return True




# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)