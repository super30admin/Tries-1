# Time Complexity :  O(1)
# Space Complexity :O(n)
# Passed on Leetcode: yes

class TrieNode():
    def __init__(self):
        self.flag = False
        self.trie_arr = [None for _ in range(26)]

class Trie():
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for char in word:
            idx = ord(char) - ord('a')
            if node.trie_arr[idx] == None:
                 node.trie_arr[idx] = TrieNode()
            node = node.trie_arr[idx]
        node.flag = True

    def searchPrefix(self, word):
        node = self.root
        res = ''
        for char in word:
            idx = ord(char) - ord('a')
            if node.trie_arr[idx] is not None:
                res += char
                node = node.trie_arr[idx]
                if node.flag:
                    return res
            else:
                break
        return word

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for val in dictionary:
            trie.insert(val)

        res = ''
        sentence_arr = sentence.split(' ')
        for val in sentence_arr[:-1]:
            res += trie.searchPrefix(val) + ' '
        res += trie.searchPrefix(sentence_arr[-1]
)
        return res