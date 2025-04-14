'''
    Time Complexity: O(n)
    Space complexity: O(nl)
'''
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for i in range(26)]

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        cur = self.root
        for char in word:
            index = ord(char) - ord('a')

            if not cur.children[index]:
                cur.children[index] = TrieNode()
            
            cur = cur.children[index]

        cur.isEnd = True
        

    def search(self, word: str) -> bool:
        cur = self.root

        for char in word:
            index = ord(char) - ord('a')

            if not cur.children[index]:
                return False

            cur = cur.children[index]

        return cur.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        cur = self.root

        for char in prefix:
            index = ord(char) - ord('a')

            if not cur.children[index]:
                return False

            cur = cur.children[index]

        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)