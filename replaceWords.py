"""
TC - O(nm)
sc - O(nm)
"""
class TrieNode:
    def __init__(self):
        self.children = collections.defaultdict(TrieNode)
        self.isWord = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for w in word:
            node = node.children[w]
        node.isWord = True

    def search(self, word):
        node = self.root
        off = ''
        for c in word:
            if c not in node.children: break
            node = node.children[c]
            off += c
            if node.isWord: return off
        return word

class Solution:
    def replaceWords(self, dict: List[str], sentence: str) -> str:
        trie = Trie()
        for words in dict:
            trie.insert(words)
        rtnData = ''
        for sent in sentence.split():
            if rtnData:
                rtnData += ' '
            rtnData += trie.search(sent)
        return rtnData