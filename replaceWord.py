class TrieNode:
    def __init__(self):
        self.children = {}
        self.endOfWord = False

class Trie:
    # O(1) time
    def __init__(self):
        self.root = TrieNode()

    # O(w) time and space complexity where w is the length of the word
    def insert(self, word):
        cur = self.root

        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
        cur.endOfWord = True

    # O(p) where p is the length of the prefix
    def searchPref(self, prefix):
        cur = self.root
        root_word = ""

        for c in prefix:
            if c not in cur.children:
                return ""
            root_word += c
            cur = cur.children[c]

            if cur.endOfWord == True:
                return root_word
        return ""

class Solution:
    # O(w*p) time where w is the num of words and p is the num of prefix
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()

        for word in dictionary:
            trie.insert(word)

        ans = []
        sentence_words = sentence.split()

        for word in sentence_words:
            root_word = trie.searchPref(word)
            if root_word != "":
                ans.append(root_word)
            else:
                ans.append(word)

        return " ".join(ans)
