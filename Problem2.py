# 648. Replace Words
class Solution:
    class Trie:
        class TrieNode:
            def __init__(self):
                self.isEnd = False
                self.children = [None] * 26
        def __init__(self):
            self.root = self.TrieNode()

        def insert(self,word):
            curr = self.root
            for c in word:
                if curr.children[ord(c)-ord('a')] == None:
                    curr.children[ord(c)-ord('a')] = self.TrieNode()
                curr = curr.children[ord(c)-ord('a')]

            curr.isEnd = True

    def __init__(self):
        self.trie = self.Trie()

    def getShortestVersion(self,word):
        sb = []
        curr = self.trie.root
        for c in word:
            if curr.children[ord(c)-ord('a')] == None or curr.isEnd:
                break
            curr = curr.children[ord(c)-ord('a')]
            sb.append(c)
        if curr.isEnd:
            return ''.join(sb)
        return word

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.trie = self.Trie()
        for word in dictionary:
            self.trie.insert(word)
        sb = []
        splitArray = sentence.split(" ")
        for str_ in splitArray:
            shortest = self.getShortestVersion(str_)
            sb.append(shortest)

        return ' '.join(sb)
        
        