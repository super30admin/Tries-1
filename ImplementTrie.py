# class TrieNode :
#     def __init__(self):
#         self.children = [None]*26
#         self.isEnd = False

# class Trie:

#     def __init__(self):
#         self.root = TrieNode()

#     def insert(self, word: str) -> None:
#         curr = self.root
#         for c in word:
#             i = ord(c)-ord('a')
#             if curr.children[i] == None:
#                 curr.children[i] = TrieNode()
#             curr = curr.children[i]
#         curr.isEnd = True


#     def search(self, word: str) -> bool:
#         curr = self.root
#         for c in word:
#             i = ord(c)-ord('a')
#             if curr.children[i] == None:
#                 return False
#             curr = curr.children[i]
#         return curr.isEnd
        

#     def startsWith(self, prefix: str) -> bool:
#         curr = self.root
#         for c in prefix:
#             i = ord(c)-ord('a')
#             if curr.children[i] == None:
#                 return False
#             curr = curr.children[i]
#         return True
        

# Using hashMap
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = {}

class Trie:

    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        curr.isEnd = True
        

    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            if c not in curr.children:
                return False
            curr = curr.children[c]
        return curr.isEnd 
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            if c not in curr.children:
                return False
            curr = curr.children[c]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)