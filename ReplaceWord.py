class TrieNode:
    def __init__(self):
        self.children={}
        self.EndOfWord= False
class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self,word):
        curr = self.root
        for c in word:
            if c not in curr.children:
                curr.children[c]= TrieNode()
            curr = curr.children[c]
        curr.EndOfWord= True

    def search(self,word):
        res = ""
        curr = self.root
        for c in word:
            if c not in curr.children:
                break
            curr = curr.children[c]
            res += c
            if curr.EndOfWord:
                return res
        return word

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:
            trie.insert(word)
        
        words = sentence.split()
        return " ".join(trie.search(word) for word in words)