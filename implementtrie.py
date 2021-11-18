class Trie:

    def __init__(self):
        self.children = {}
        self.isWord = False

    def insert(self, word: str) -> None:
        cur = self
        for w in word:
            if w not in cur.children:
                cur.children[w] = Trie()
            cur = cur.children[w]
            # if w not in cur.children:
            #     cur.children[w]={}
            # if w not in cur.children:

        cur.isWord = True

    def search(self, word: str) -> bool:
        cur = self
        for w in word:
            if w not in cur.children:
                return False
            cur = cur.children[w]
        return cur.isWord

    def startsWith(self, prefix: str) -> bool:
        cur = self
        for w in prefix:
            if w not in cur.children:
                return False
            cur = cur.children[w]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)


# import scrapy
# class Trie:
#
#     def __init__(self):
#         self.trie = {}
#
#     def insert(self, word: str) -> None:
#         current = self.trie
#         for c in word:
#             if c not in current:
#                 current[c] = {}
#             current = current[c]
#         current["_"] = True
#
#     def search(self, word: str) -> bool:
#         current = self.trie
#         for c in word:
#             if c not in current:
#                 return False
#             current = current[c]
#         return "_" in current
#
#     def startsWith(self, prefix: str) -> bool:
#         current = self.trie
#         for c in prefix:
#             if c not in current:
#                 return False
#             current = current[c]
#         return True
#
# # Your Trie object will be instantiated and called as such:
# # obj = Trie()
# # obj.insert(word)
# # param_2 = obj.search(word)
# # param_3 = obj.startsWith(prefix)