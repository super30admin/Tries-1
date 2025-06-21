"""
Use a nested dictionary or TrieNode class to represent children
Mark end of word with a boolean
Move through characters for insert/search/prefix operations
"""
"""
Time Complexity: Insert/Search/Prefix: O(L) where L = length of word/prefix 
Space Complexity: O(N * L) for storing N words of average length L
"""



class TrieNode:
    def __init__(self):
        self.children = {}
        self.end_of_word = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for ch in word:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            node = node.children[ch]
        node.end_of_word = True

    def search(self, word: str) -> bool:
        node = self.root
        for ch in word:
            if ch not in node.children:
                return False
            node = node.children[ch]
        return node.end_of_word

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for ch in prefix:
            if ch not in node.children:
                return False
            node = node.children[ch]
        return True


if __name__ == "__main__":
    trie = Trie()
    trie.insert("apple")
    print(trie.search("apple"))   
    print(trie.search("app"))      
    print(trie.startsWith("app")) 
    trie.insert("app")
    print(trie.search("app"))    
