## Approach
# Time - O(N) all operations 
# Space - O(N) where N is the length of the word

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode()


    def insert(self, word: str) -> None:

        current = self.root
        for i in range(len(word)):
            char = word[i]
            if current.children[ord(char) - ord('a')] == None:
                current.children[ord(char) - ord('a')] = TrieNode()

            current = current.children[ord(char) - ord('a')]

        current.isEnd = True


    def search(self, word: str) -> bool:
        current = self.root
        for i in range(len(word)):
            char = word[i]
            if current.children[ord(char) - ord('a')] == None:
                return False

            current = current.children[ord(char) - ord('a')]

        return current.isEnd


    def startsWith(self, prefix: str) -> bool:
        current = self.root
        for i in range(len(prefix)):

            char = prefix[i]
            if current.children[ord(char) - ord('a')] == None:
                return False
            current = current.children[ord(char) - ord('a')]

        return True

