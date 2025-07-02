from typing import List,Deque
from collections import deque
class TrieNode :
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            i = ord(c)-ord('a')
            if curr.children[i] == None:
                curr.children[i] = TrieNode()
            curr = curr.children[i]
        curr.isEnd = True


    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            i = ord(c)-ord('a')
            if curr.children[i] == None:
                return False
            curr = curr.children[i]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            i = ord(c)-ord('a')
            if curr.children[i] == None:
                return False
            curr = curr.children[i]
        return True
        
# class Solution:
#     def longestWord(self, words: List[str]) -> str:
#         trie = Trie()
#         res = []
#         maxStr = ""
#         for word in words:
#             trie.insert(word)
#         queue = deque()
#         queue.append((trie.root, ""))
#         while queue:
#             node, path = queue.popleft()
#             if len(path) >= len(maxStr):
#                 maxStr = path
#             for i in range(25,-1,-1):
#                 child = node.children[i]
#                 if child and child.isEnd:
#                     queue.append((child, path+chr(ord('a') + i)))
#         return maxStr

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        res = []
        self.maxStr = ""
        for word in words:
            trie.insert(word)
        def helper(curr , sb):
            #base
            if curr!=trie.root and not curr.isEnd : return 
            if len(sb) > len(self.maxStr):
                self.maxStr = "".join(sb)

            #logic
            #action
            for i in range(26):
                if curr.children[i]:
                    l = len(sb)
                    sb.append(chr(ord('a')+i))
                    #recurse
                    helper(curr.children[i], sb)
                    sb.pop()

        helper(trie.root , [])
        return self.maxStr
        
        