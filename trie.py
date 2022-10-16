#Time Complexity: O(m)
#Space Complexity: O(m)
#Did it run on leetcode: Yes

class TrieNode:
    def __init__(self):
        self.childNodes = {}
        self.isWordEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        currNode = self.root
        for ch in word:
            node = currNode.childNodes.get(ch , TrieNode())
            currNode.childNodes[ch] = node
            currNode = node
        currNode.isWordEnd = True



    def search(self, word: str) -> bool:

        currNode = self.root
        for ch in word:
            node = currNode.childNodes.get(ch)
            if  not node:
                return False
            currNode = node

        return currNode.isWordEnd


    def startsWith(self, prefix: str) -> bool:
        currNode = self.root
        for ch in prefix:
            node = currNode.childNodes.get(ch)
            if not node:
                return False
            currNode = node

        return True