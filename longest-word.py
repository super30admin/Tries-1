#Time Complexity : O(n)
#Space Complexity : O(n)
class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        curr = self.root
        for c in word:
            i = ord(c) - ord("a")
            if curr.children[i] is None:
                curr.children[i] = TrieNode()
            curr = curr.children[i]
        curr.isEnd = True

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for word in words:
            trie.insert(word)
        
        res = ""
        for word in words:
            if len(word) < len(res):
                continue
            if len(word) == len(res) and word >= res:
                continue
            
            curr = trie.root
            is_valid = True
            for c in word:
                i = ord(c) - ord("a")
                curr = curr.children[i]
                if not curr.isEnd:
                    is_valid = False
                    break
            
            if is_valid:
                res = word
        
        return res
