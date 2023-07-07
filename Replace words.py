# Time complexity : O(n*L) n is number of words, L is average length of each word
# Space complexity : O(size of dictionary) to store the trie
# The code ran on Leetcode

# Create a trie with all the words in the dictionary. Search for the replacement word in the trie for every word in the sentence and add it to the final result
class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.EoW = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        cur = self.root
        for w in word:
            idx = ord(w) - ord('a')
            if cur.children[idx] == None:
                cur.children[idx] = TrieNode()
            cur = cur.children[idx]
        cur.EoW = True

    def search(self, word):
        cur = self.root
        for w in word:
            idx = ord(w) - ord('a')
            if cur.children[idx] == None:
                return False
            else:
                cur = cur.children[idx]
        return cur.EoW

    def get_replacement(self, word):
        cur = self.root
        res = ''
        for w in word:
            idx = ord(w) - ord('a')
            if cur.children[idx] == None:
                return word
            else:
                res += w
                if cur.children[idx].EoW == True:
                    return res
            cur = cur.children[idx]
        return word

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for d in dictionary:
            trie.insert(d)

        res = ''

        for s in sentence.split(' '):
            res += trie.get_replacement(s)
            res += ' '
            
        return res.strip()
        