class TrieNode:
    def __init__(self):
        self.children={}
        self.isEndOfWord=False

class Trie:
    def __init__(self):
        self.root=TrieNode()

    def insert(self,word):
        node=self.root
        for char in word:
            if char not in node.children:
                node.children[char]=TrieNode()
            node=node.children[char]
        node.isEndOfWord=True

    def search(self,word):
        node=self.root
        for char in word:
            if char not in node.children:
                return False
            node=node.children[char]
        return node.isEndOfWord
    
    def startsWith(self,prefix):
        node=self.root
        for char in prefix:
            if char not in node.children:
                return False
            node=node.children[char]
        return True
    
trie=Trie()
trie.insert("apple")
print(trie.search("apple"))
print(trie.search("app"))
print(trie.startsWith("app"))
trie.insert("app")
print(trie.search("app"))