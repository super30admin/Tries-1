class TrieNode:

    def __init__(self): 
        self.children = {}
        self.eow = False

    def addword(self, word):
        curr = self

        for ch in word:
            if ch not in curr.children: 
                curr.children[ch] = TrieNode()

            curr = curr.children[ch]
        curr.eow = True

    
class Solution:
    def longestWord(self, words: List[str]) -> str:

        root = TrieNode()
        self.res = ""
        for word in words: 
            root.addword(word)

        
        def dfs(curr, path):

            # Base condition
            if curr.eow:
                word = ''.join(path)
                if len(word) > len(self.res) or (len(word) == len(self.res) and word < self.res):
                    self.res = word

            children = curr.children

            for ch in children.keys(): 
                child = curr.children[ch]
                if child != None and child.eow == True: 
                    path.append(ch)
                    dfs(child, path)
                    path.pop()

        dfs(root, [])

        return self.res


