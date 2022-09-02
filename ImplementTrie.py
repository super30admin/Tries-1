# Time Complexity : O(N)        N = lenght of longest word
# Space Complexity : O(L * N)   N = number of words, L = avg length of each word

class TrieNode:
    isEnd = False
    children = []

    def __init__(self) -> None:
        self.isEnd = False
        self.children = [None] * 26

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            pos = ord(ch) - ord('a')
            if curr.children[pos] == None:
                curr.children[pos] = TrieNode()
            curr = curr.children[pos]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            pos = ord(ch) - ord('a')
            if curr.children[pos] == None:
                return False
            curr = curr.children[pos]

        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(len(prefix)):
            ch = prefix[i]
            pos = ord(ch) - ord('a')
            if curr.children[pos] == None:
                return False
            curr = curr.children[pos]

        return True




# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)