#Time complexity: O(L)
#Space complexity: O(1)

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for i in range(26)]
class Trie:     
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            if curr.children[ord(word[i])-ord('a')] is None:
                curr.children[ord(word[i])-ord('a')] = TrieNode()
            curr = curr.children[ord(word[i])-ord('a')]
        curr.isEnd = True
        

    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(len(word)):
            if curr.children[ord(word[i])-ord('a')] is None:
                return False
            curr = curr.children[ord(word[i])-ord('a')]
        return curr.isEnd
        
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(len(prefix)):
            if curr.children[ord(prefix[i])-ord('a')] is None:
                return False
            curr = curr.children[ord(prefix[i])-ord('a')]
        return True
        
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
