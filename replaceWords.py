#TC - O(max(m,n)*l)
#SC - O(max(m,n)*l)
class TrieNode:
    def __init__(self):
        self.children = {}
        self.endOfWord = False 
class Trie:
    def __init__(self):
            self.root = TrieNode()
    def insert(self, word):
        cur = self.root
        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
        cur.endOfWord = True 
    def search(self,word):
        cur = self.root
        a = ""
        for c in word:
            if c not in cur.children:
                break 
            a+=c
            cur = cur.children[c]
            if cur.endOfWord:
                return a
        return word

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:
            trie.insert(word)
        res = ''
        for word in sentence.split():
            if res:
                res+= ' '
            res += trie.search(word)
        return res

            
        
        
            
        