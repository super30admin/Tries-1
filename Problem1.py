#Time complexit o(l), l is the lenght of the string
#space complexity o(n * m) n is the number of words and m is the length of the word

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            index = ord(ch) - ord('a')
            if index not in curr.children:
                curr.children[index] = TrieNode()
            curr = curr.children[index]
        curr.isEnd = True
        

    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            index = ord(ch) - ord('a')
            if index not in curr.children:
                return False
            curr = curr.children[index]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for ch in prefix:
            index = ord(ch) - ord('a')  
            if index not in curr.children:  
                return False
            curr = curr.children[index]
        return True  
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)