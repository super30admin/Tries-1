# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False


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
        currentNode = self.root
        for i in range(len(word)):
            c = word[i]
            if c not in currentNode.children:
                currentNode.children[c] = TrieNode()
            currentNode = currentNode.children[c]

        currentNode.isEnd = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        currentNode = self.root
        for i in range(len(word)):
            c = word[i]
            if c not in currentNode.children:
                return False
            currentNode = currentNode.children[c]
        return currentNode.isEnd

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        currentNode = self.root
        for i in range(len(prefix)):
            c = prefix[i]
            if c not in currentNode.children:
                return False
            currentNode = currentNode.children[c]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)