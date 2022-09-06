# Time complexity : O(n) time for insert and search where l is len(word), O(k) time for startsWith where k is len(prefix)
# Space complexity : O (n * 26 ^ k)
class TrieNode():
        def __init__(self):
            self.children = [None for _ in range(26)] #26 assuming that we are only dealing with lower case letters
            self.isEnd = False
class Trie:
    
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c)-ord('a')] == None:
                curr.children[ord(c)-ord('a')] = TrieNode()
            curr = curr.children[ord(c)-ord('a')]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        curr = self.root
        
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c)-ord('a')] == None:
                return False
            curr = curr.children[ord(c)-ord('a')]
        return curr.isEnd

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