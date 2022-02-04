#time complexity: O(N): N is the lengthof words array, to build tree and to search
#Space: O(N)
import collections
class TrieNode:
    def __init__(self):
        self.children={}
        self.endOfWord = False
        self.word = ''

class Trie:
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word):
        node = self.root
        
        for letter in word:
            if letter not in node.children:
                node.children[letter]=TrieNode()
            node = node.children[letter]
        node.endOfWord = True
        node.word = word
        
    def bfs(self):
        res = ""
        q = collections.deque([self.root])
        while q:
            cur = q.popleft()
            for n in cur.children.values():
                if n.endOfWord:
                    q.append(n)
                    if len(n.word) > len(res) or res > n.word: 
                        res = n.word
        return res
                
        
class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for w in words: trie.insert(w)
        return trie.bfs()