# 208. Implement Trie (Prefix Tree)
# https://leetcode.com/problems/implement-trie-prefix-tree/

class trieNode:
    def __init__(self):
        self.isEnd = False
        self.children = dict()

class Trie:
    def __init__(self):
        self.root = trieNode()

    # Time Complexiety: O(len(word))
    # Space Complexiety: O(len(word))
    def insert(self, word: str) -> None:
        curr = self.root
        for i in word:
            if curr.children.get(i) == None:
                curr.children[i] = trieNode()
            curr = curr.children[i]
        curr.isEnd = True

    # Time Complexiety: O(len(word))
    # Space Complexiety: O(1)
    def search(self, word: str) -> bool:
        curr = self.root
        for i in word:
            if curr.children.get(i) == None:
                return False
            curr = curr.children[i]
        return curr.isEnd == True

    # Time Complexiety: O(len(prefix))
    # Space Complexiety: O(1)
    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in prefix:
            if curr.children.get(i) == None:
                return False
            curr = curr.children[i]
        return True


# Your Trie object will be instantiated and called as such:
obj = Trie()
obj.insert('adds')
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
print(obj.search('ad'))