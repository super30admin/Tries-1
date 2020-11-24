class TrieNode:
    def __init__(self):
        self.word = False
        self.children = {}

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.word = True

    def search_prefix(self, word):
        node = self.root
        for i, c in enumerate(word):
            if c in node.children:
                if node.children[c].word: return word[:i+1]
                node = node.children[c]
            else:
                return False
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:
            trie.insert(word)
        res = []
        for word in sentence.split():
            s = trie.search_prefix(word)
            if s:
                res.append(s)
            else:
                res.append(word)

        return " ".join(res) 
