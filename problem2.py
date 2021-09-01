#longest word in a palindrome
#time complexity:O(m*k) where m is the length of the characters and K would be the number of words in the dict
#space complexity:O(N)

class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.word = None
    def addWord(self, word):
        cur = self
        for c in word:
            cur = cur.children[c]
        cur.word = word

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trieRoot = TrieNode()
        for word in words:
            trieRoot.addWord(word)
            
        ans = ""
        bfs = deque([trieRoot])
        while bfs:
            cur = bfs.popleft()
            for child in cur.children.values():
                if child.word != None:
                    if len(child.word) > len(ans) or len(child.word) == len(ans) and child.word < ans:
                        ans = child.word
                    bfs.append(child)
        return ans