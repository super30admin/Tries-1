'''
    Time Complexity: O(nlogn + nl)
    Space Complexity: O(nl)
'''
class TrieNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isEnd = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
        self.result = ""

    def insert(self, word):
        cur = self.root
        isDifferent = False

        for i in range(len(word)):
            index = ord(word[i]) - ord('a')

            if not cur.children[index]:
                cur.children[index] = TrieNode()

            cur = cur.children[index]

            if not cur.isEnd and i < len(word)-1:
                isDifferent = True
        
        cur.isEnd = True

        if not isDifferent and len(word) > len(self.result):
            self.result = word

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        words.sort()

        for word in words:
            trie.insert(word)

        return trie.result
