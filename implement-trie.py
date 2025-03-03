# Time O(n)
# Space O(n*26) n : longest word length
class Trie:
    class TrieNode:
        def __init__(self, isEnd=False):
            self.chars = [None] * 26
            self.isEnd = isEnd

    def __init__(self):
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            i = ord(c) - ord('a')
            if curr.chars[i] == None: 
                curr.chars[i] = self.TrieNode()
            curr = curr.chars[i]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            i = ord(c) - ord('a')
            if curr.chars[i] == None: return False
            curr = curr.chars[i]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            i = ord(c) - ord('a')
            if curr.chars[i] != None: curr = curr.chars[i]
            else: return False
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)