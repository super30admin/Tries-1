class TrieNode:
    def __init__(self):
        self.children = {}
        self.stopping_condition = False

class Trie:
    '''
    Trie is represnted as
    {'a':{'p':{'p':{'l':{'e':{   } } } } } }
    '''

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        curr.stopping_condition  = True

    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            if c not in curr.children:
                return False
            else:
                curr = curr.children[c]
        return curr.stopping_condition

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            if c not in curr.children:
                return False
            curr = curr.children[c]
        return True
