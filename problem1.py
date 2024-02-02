#Time Complexity : O(m), where T is the target value.
#Space Complexity :O(26*n)
#Did this code successfully run on Leetcode : yes

class Node:
    def __init__(self):
        self.node = [None] * 26
        self.flag = False

    def set_end(self):
        self.flag = True

class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        node = self.root
        for char in word:
            index = ord(char) - ord('a')
            if not node.node[index]:
                node.node[index] = Node()
            node = node.node[index]
        node.set_end()

    def search(self, word: str) -> bool:
        node = self.root
        for char in word:
            index = ord(char) - ord('a')
            if not node.node[index]:
                return False
            node = node.node[index]
        return node.flag

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for char in prefix:
            index = ord(char) - ord('a')
            if not node.node[index]:
                return False
            node = node.node[index]
        return True