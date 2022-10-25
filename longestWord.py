"""
TC - O(nm)
SC - O(nm)
"""

class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.word = None
    
    def add(self, word):
        cur = self
        for c in word:
            cur = cur.children[c]
        cur.word = word

class Solution:
    def longestWord(self, words: List[str]) -> str:
        curr = TrieNode()
        for word in words:
            curr.add(word)

        rtnData = ""
        bfs = deque([curr])
        while bfs:
            cur = bfs.popleft()
            for child in cur.children.values():
                if child.word != None:
                    if len(child.word) > len(rtnData) or len(child.word) == len(rtnData) and child.word < rtnData:
                        rtnData = child.word
                    bfs.append(child)
        return rtnData