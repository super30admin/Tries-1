#Time: O(n), n is length of word
#Space: O(26^maxDepth)
#did the code run? yes
# Approach:
#a trie node can have children implemented as array or hashmap
#traverse to the last letter of the word, by creating new nodes if a child is not present and mark its a word
class Node:
    
    def __init__(self, isWord = False):
        self.children = [None for _ in range(26)]
        self.isWord = isWord
        
class Trie:

    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            idx = ord(c)-ord('a')
            if not curr.children[idx]:
                curr.children[idx] = Node()
            curr = curr.children[idx]
        curr.isWord = True
        return

    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            idx = ord(c)-ord('a')
            if not curr.children[idx]:
                return False
            curr = curr.children[idx]
        return curr.isWord

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            idx = ord(c)-ord('a')
            if not curr.children[idx]:
                return False
            curr = curr.children[idx]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)