"""
Time: 0(k) -> for trie structure to iterate
      0(k) -> for insert a string
Space: 0(n) -> build trie
"""

class Trie:
    class TrieNode:
        def __init__(self):
            self.children = [None for _ in range(26)]
            self.flag = False
            

    def __init__(self):
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c)-ord('a')] == None:
                curr.children[ord(c)-ord('a')] = self.TrieNode()
            curr = curr.children[(ord(c)-ord('a'))]
        curr.flag = True
        
    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c)-ord('a')] == None:
                return False
            curr = curr.children[ord(c)-ord('a')]
        return curr.flag
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(len(prefix)):
            c = prefix[i]
            if curr.children[ord(c)-ord('a')] == None:
                return False
            curr = curr.children[ord(c)-ord('a')]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)