# Time complexity - o(N+L)
# Space Complexity - o(N+L)

class TrieNode:

    def __init__(self):
        self.children = [None]*26
        self.isEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word)->None:
        curr = self.root
        
        for c in word:
            position = ord(c)-ord('a')
            if curr.children[position] is None:
                curr.children[position] = TrieNode()

            curr = curr.children[position]

        curr.isEnd = True

    def search(self, word)->bool:
        curr = self.root
        for c in word:
            position = ord(c)-ord('a')
            if curr.children[position] is None:
                return False
            curr = curr.children[position]

        return curr.isEnd
          
    def startsWith(self, word):
        curr = self.root
        for c in word:
            position = ord(c)-ord('a')
            if curr.children[position] is None:
                return False
            curr = curr.children[position]

        return True

class Solution:
    def longestWord(self, words: List[str]) -> str:
        obj = Trie()
        for w in words:
            obj.insert(w)

        
        word = ''
        for w in words:
            found = True
            prefix = ''
            for c in w:
                prefix+=c
                if not obj.search(prefix):
                    found = False
                    break

            if found:
                if len(word)<len(w) or (len(word)==len(w) and word>w):
                    word = w

        return word

            


        
        