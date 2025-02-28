# Time Complexity : O(m*l)
# Space Complexity : O(n*l)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO
class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isWord = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        cur = self.root
        for c in word:
            key = ord(c) - ord("a")
            if cur.children[key]:
                cur = cur.children[key]
            else:
                cur.children[key] = TrieNode()
                cur = cur.children[key]
        cur.isWord = True

    def returnPrefix(self, word):
        cur = self.root
        prefix = ""
        for c in word:
            key = ord(c) - ord("a")
            if cur.children[key]:
                prefix += c
                cur = cur.children[key]
                if cur.isWord:
                    return prefix
            else:
                return word
        return word

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:
            trie.insert(word)
        

        s_words = sentence.split(" ")
        res = ""
        for word in s_words:
            res += trie.returnPrefix(word)
            res += " "
        
        return res[:-1]