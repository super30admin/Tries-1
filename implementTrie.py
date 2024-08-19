class Trie:
    class TrieNode:
        def __init__(self):
            # the attributes to be instance variables
            self.children = [None for _ in range(26)]
            self.isEnd = False

    def __init__(self):
        self.root = self.TrieNode()  # Initialize the root node

    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            # Fixed the usage of 'c' to 'c'
            if curr.children[ord(c) - ord('a')] is None:
                curr.children[ord(c) - ord('a')] = self.TrieNode()
            
            curr = curr.children[ord(c) - ord('a')]
        curr.isEnd = True  # Mark the end of the word

    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            # Fixed the usage of 'c' to 'c'
            if curr.children[ord(c) - ord('a')] is None:
                return False
            curr = curr.children[ord(c) - ord('a')]
        return curr.isEnd  # Return true only if it's the end of a word

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(len(prefix)):  # Corrected 'word' to 'prefix'
            c = prefix[i]
            # Fixed the usage of 'c' to 'c'
            if curr.children[ord(c) - ord('a')] is None:
                return False
            curr = curr.children[ord(c) - ord('a')]
        return True  # If we successfully reach here, the prefix exists
