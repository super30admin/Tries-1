#Time: O(n), n is length of word
#Space: O(26^maxDepth)
#did the code run? yes
# Approach:
# since there is no data to be stored at each node, this implementation uses hashmap instead of a class for nodes
#a node can have children implemented as array or hashmap
#traverse to the last letter of the word, by creating new nodes if a child is not present and mark its a word

class Trie:

    def __init__(self):
        self.root = {}

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            if c not in curr:
                curr[c] = {}
            curr = curr[c]
        curr['isWord'] = True
        return

    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            if c not in curr:
                return False
            curr = curr[c]
        return 'isWord' in curr

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            if c not in curr:
                return False
            curr = curr[c]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)