# Time Complexity: O(NL+ML) NL for insertion and ML for search
# Space Complexity: O(NL) For the insertion to trie
class TrieNode:
    def __init__(self, val=None):
        self.val = val
        self.children = [None] * 26
        self.isWord = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def getRoot(self):
        return self.root

    def insert(self, word: str):
        temp = self.root
        for ch in word:
            index = ord(ch) - ord('a')
            if temp.children[index] is None:
                temp.children[index] = TrieNode(ch)
            temp = temp.children[index]
        temp.isWord = True

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:
            trie.insert(word)
        
        root = trie.getRoot()
        words = sentence.split()
        result = []

        for word in words:
            temp = root
            prefix = ""
            replaced = False
            for ch in word:
                prefix+=ch
                idx = ord(ch) - ord('a')
                if temp.children[idx] is None:
                    break
                temp = temp.children[idx]
                if temp.isWord:
                    result.append(prefix)
                    replaced = True
                    break
            if not replaced:
                result.append(word)
        return " ".join(result)


