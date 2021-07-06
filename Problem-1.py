"""
Approach: This is an list/array implementation of Trie.
1) Maintain an array of 26 elements at each node. a) if a TrieNode exits at any of those indices of the array, that means
 you have a char at that node. char value = index number substitution of alphabets
2) you also maintain a boolean isEnd to signify if the chars from root to current node construct a complete word

TC: insert: O(n), search: O(n) and startswith: O(m). where n = word length and m = prefix length
SC: O(n) where n = number of chars in the Trie

"""

class TrieNode:
    def __init__(self):
        self.array = [False] * 26
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
        index = 0
        curr = self.root
        while index < len(word):
            char = word[index]
            pos = ord(char) - ord('a')
            if not curr.array[pos]:
                curr.array[pos] = TrieNode()
            curr = curr.array[pos]
            index += 1
        curr.isEnd = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        index = 0
        curr = self.root
        while index < len(word):
            char = word[index]
            pos = ord(char) - ord('a')
            if not curr.array[pos]:
                return False
            index += 1
            curr = curr.array[pos]
        if not curr.isEnd:
            return False
        return True

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        index = 0
        curr = self.root
        while index != len(prefix):
            char = prefix[index]
            pos = ord(char) - ord('a')
            if not curr.array[pos]:
                return False
            index += 1
            curr = curr.array[pos]
        return True



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)