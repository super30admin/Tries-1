# TImecomplexity - Search -Insert - O(s) s - length of word/prefix
class Trie:

    def __init__(self):
        self.child = dict()


    def insert(self, word: str) -> None:
        node = self.child
        for ch in word:
            if ch not in node:
                node[ch] = dict()
            node = node[ch]
        node["is_word"] = True


    def search(self, word: str) -> bool:
        node = self.child
        for ch in word:
            if ch not in node:
                return False
            node = node[ch]
        return node.get("is_word")

    def startsWith(self, prefix: str) -> bool:
        node = self.child
        for ch in prefix:
            if ch not in node:
                return False
            node = node[ch]
        return True



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
