class TrieNode:
    def __init__(self):
        self.hasharr = [None for i in range(26)]
        self.word = ''
class Trie:
    def __init__(self):
        self.BaseNode = TrieNode()
        
    def insert(self,word):
        node = self.BaseNode
        for char in word:
            if node.hasharr[ord(char) - ord('a')] is None:
                node.hasharr[ord(char) - ord('a')] = TrieNode()
            node = node.hasharr[ord(char) - ord('a')]
        
        node.word = word
        
    def search(self,word):
        node = self.BaseNode
        for char in word:
            if node.hasharr[ord(char) - ord('a')] is not None:
                node = node.hasharr[ord(char) - ord('a')]
                if node.word != '':
                    return node.word
            else:
                return ""
        return ""
                                    
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:
            trie.insert(word)
            # print(trie.search(word))
        final = []
        words = sentence.split(" ")
        for word in words:
            pre = trie.search(word)
            if pre != "":
                final.append(pre)
            else:
                final.append(word)
        return ' '.join(final)