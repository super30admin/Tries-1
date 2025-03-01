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
        curr = self.root
        for c in word:
            if c not in curr.children or not curr.children[c].EndOfWord:
                return False
            curr = curr.children[c]
        return True


class Solution:
    def longestWord(self, words: List[str]) -> str:
        t = Trie()

        for word in words:
            t.insert(word)
        words.sort()
        longest =""
        for word in words:
            if t.search(word):
                if len(word) > len(longest):
                    longest = word
        return longest
