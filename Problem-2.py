class TrieNode:
    def __init__(self) -> None:
        self.isWord = False
        self.children = {}

class Trie:
    def __init__(self) -> None:
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for ch in word:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            node = node.children[ch]
        node.isWord = True 

    def allLettersAreWords(self, word):
        node = self.root
        for i in word:
            if not node.children[i].isWord:
                return False
            node = node.children[i]
        return True

class Solution:    
    def longestWord(self, words: List[str]):
        trie = Trie()
        for word in words:
            trie.insert(word)

        maxCount = 0
        res = ""

        for word in words:
            if not trie.allLettersAreWords(word):
                continue

            count = len(word)
            if count > maxCount:
                maxCount = count
                res = word
            elif count == maxCount:
                if word < res:
                    res = word
        print(res)
        return res