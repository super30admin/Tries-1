"""
n = len(words array)
t.c. => n*w (all the characters)
s.c. => n*w (all the characters)
"""
class Trie:
    def __init__(self):
        self.isEnd = False
        self.children = [None for i in range(26)]

class Solution:
    def __init__(self):
        self.maxWord = ""
        self.maxlen = 0
        
    def longestWord(self, words: List[str]) -> str:
        parent = Trie()
        
        for w in words:
            root = parent
            for c in w:
                index = ord(c) - ord('a')
                if not root.children[index]:
                    root.children[index] = Trie()
                root = root.children[index]
            root.isEnd = True
        
        path = []
        def dfs(root, wlen):
            if wlen > 0 and not root.isEnd:
                if wlen - 1 > self.maxlen:
                    self.maxlen = wlen
                    self.maxWord = "".join(path[:-1].copy())
                return 
            
            if root.isEnd:

                if wlen > self.maxlen:
                    self.maxlen = wlen
                    self.maxWord = "".join(path.copy())


            for i in range(26):
                if not root.children[i]:
                    continue
                
                path.append(chr(i + ord('a')))
                dfs(root.children[i], 1 + wlen)
                path.pop()

        dfs(parent, 0)
        return self.maxWord
