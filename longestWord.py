import collections

class TrieNode:
    def __init__(self, char = ""):
        self.char = char
        self.children = {}
        self.word = None

    def insert(self, word):
        cur = self
        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode(c)
            cur = cur.children[c]
        cur.word = word
        
# TC : O(L), L => sum of length of all words
# SC : O(L)
class Solution:
    def longestWord(self, words: List[str]) -> str:
        node = TrieNode()
        for word in words:
            node.insert(word)
        
        q = collections.deque([node,])
        qs = []
        string = ""
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for c in curr.children.values():
                    if c.word != None:
                        q.append(c)
                        print(c.word)
                        if len(string) < len(c.word) or len(string) == len(c.word) and c.word < string:
                            string = c.word

        return string