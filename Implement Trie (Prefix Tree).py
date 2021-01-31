class Trie:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        #Time Complexity: O(length(word))
        #Space Complexity: O(1)     // no auxiliary space
        
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for char in word:
            idx = ord(char) - ord('a')
            if not curr.children[idx]:
                curr.children[idx] = TrieNode()
            curr = curr.children[idx]
        curr.isEnd = True
        return

    def search(self, word: str) -> bool:
        #Time Complexity: O(length(word))
        #Space Complexity: O(1)
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for char in word:
            idx = ord(char) - ord('a')
            if not curr.children[idx]:
                return False
            curr = curr.children[idx]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        #Time Complexity: O(length(prefix))
        #Space Complexity: O(1)
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for char in prefix:
            idx = ord(char) - ord('a')
            if not curr.children[idx]:
                return False
            curr = curr.children[idx]
        return True
        
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for i in range(26)]

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)