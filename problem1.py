class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.child = [0 for i in range(27)]

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
        curr = self.root
        for i in range(len(word)):
            if not curr.child[ord(word[i]) - ord('a')]:
                curr.child[ord(word[i]) - ord('a')] = TrieNode()
            curr = curr.child[ord(word[i]) - ord('a')]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for i in range(len(word)):
            if not curr.child[ord(word[i]) - ord('a')]: return False
            curr = curr.child[ord(word[i]) - ord('a')]
        return curr.isEnd
            

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for i in range(len(prefix)):
            if not curr.child[ord(prefix[i]) - ord('a')]: return False
            curr = curr.child[ord(prefix[i]) - ord('a')]
        return True
        
# Time complexity is O(n*L) where n is number of words and L is the length of the word
#Space complexity O(n*L) where n is number of words and L is the length of the word

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)