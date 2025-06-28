# Time complexity - o(N+L)
# Space Complexity - o(N+L)

class TrieNode:
        __slots__ = "children", "isEnd"
        isEnd:bool
        children:list

        def __init__(self):
            self.isEnd = False
            self.children = [None]*26

class Trie:

    

    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        curr = self.root

        for c in word:
            position = ord(c)-ord('a')
            if not curr.children[position]:
                curr.children[position] = TrieNode()

            curr = curr.children[position]
        curr.isEnd = True
        

    def search(self, word: str) -> bool:
        curr = self.root

        for c in word:
            position = ord(c)-ord('a')
            if not curr.children[position]:
                return False

            curr = curr.children[position]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root

        for c in prefix:
            position = ord(c)-ord('a')
            if not curr.children[position]:
                return False

            curr = curr.children[position]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)