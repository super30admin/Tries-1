class Solution:
    class TrieNode():
        def __init__(self):
            self.children=[None]*26
            self.isEnd=False
    def __init__(self):
        self.result=""
        self.root=self.TrieNode()

    def insert(self, word):
        curr=self.root
        for c in word:
            idx=ord(c)-ord('a')
            if curr.children[idx] is None:
                curr.children[idx]=self.TrieNode()
            curr=curr.children[idx]
        curr.isEnd=True

    def longestWord(self, words: List[str]) -> str:
        for word in words:
            self.insert(word)

        self.dfs(self.root,[])
        return self.result

    def dfs(self,curr,path):
        if len(self.result)<len(path):
            self.result="".join(path)

        for i in range(26):
            if curr.children[i] is not None and curr.children[i].isEnd:

                le=len(path)

                path.append(chr(i+ord('a')))
                self.dfs(curr.children[i],path)
                path=path[:le]

        