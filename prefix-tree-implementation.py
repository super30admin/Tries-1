class Trie:
    class TrieNode:
        def __init__(self):
            self.children = {}
            self.isEnd = False

    def __init__(self):
        self.root = self.TrieNode()
    
    def insert(self, word): 
        curr = self.root
        for c in word: 
            if curr.children.get(c) is None:
                curr.children[c] = self.TrieNode()
            curr = curr.children[c]
        curr.isEnd = True

    def search(self, word): 
        curr = self.root
        for c in word:
            if curr.children.get(c) is None:
                return False
            curr = curr.children[c]
        return curr.isEnd

    def startsWith(self, prefix):  # O(L)
        curr = self.root
        for c in prefix:
            if curr.children.get(c) is None:
                return False
            curr = curr.children[c]
        return True

#Time:  O(L) for insert, search, and startsWith, where L is the word length.
# Space: O(N * L) where N is number of words, and L is average word length.