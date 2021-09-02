class Trie:
    class TrieNode:
        def __init__(self):
            self.children = [None for i in range(26)]
            self.isEnd = False

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur = self.root
        for i in range(len(word)):
            c = word[i]
            if cur.children[ord(c) - 97] == None:
                cur.children[ord(c) - 97] = self.TrieNode()
            cur = cur.children[ord(c) - 97]
        cur.isEnd = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        cur = self.root
        for i in range(len(word)):
            c = word[i]
            if cur.children[ord(c) - 97] == None:
                return False
            cur = cur.children[ord(c) - 97]
        return cur.isEnd

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        cur = self.root
        for i in range(len(prefix)):
            c = prefix[i]
            if cur.children[ord(c) - 97] == None:
                return False
            cur = cur.children[ord(c) - 97]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)