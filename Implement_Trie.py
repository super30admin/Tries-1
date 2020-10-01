# Time - O(N) n is key length
# space: - O(N) for insertton and O(1) for search


class TrieNode:
    def __init__(self):
        self.word = False
        self.children = {}

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.root
        for i in word:
            if i not in node.children:
                node.children[i] = TrieNode()
            node = node.children[i]
        node.word = True
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root
        
        for i in word:
            if i in node.children:
                node = node.children[i]
            else:
                return False
        return node.word

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        
        for i in prefix:
            if i in node.children:
                node = node.children[i]
            else:
                return False
        return True
