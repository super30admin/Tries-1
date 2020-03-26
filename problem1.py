'''
Time Complexity: Listed individually below
Space Complexity: Listed individually below
Did this code successfully run on Leetcode : Yes
Explanation: Created Trie structure below based on children array for each node and EndOfWord boolean to dictate end
of word
'''
class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEndOfWord = False


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    #Time: O(N*k) ~ O(k) -> length of largest word k and n is number of words
    #Space: O(N*k) -> Overall for length of word and length of largest word
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cursor = self.root
        for i in range(0, len(word)):
            ch = word[i]
            if cursor.children[ord(ch) - ord('a')] == None:
                cursor.children[ord(ch) - ord('a')] = TrieNode()
            cursor = cursor.children[ord(ch) - ord('a')]
        cursor.isEndOfWord = True

    # Time: O(k)
    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        cursor = self.root
        for i in range(0, len(word)):
            ch = word[i]
            if cursor.children[ord(ch) - ord('a')] == None:
                return False
            cursor = cursor.children[ord(ch) - ord('a')]

        return cursor.isEndOfWord

    # Time: O(length of prefix)
    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        cursor = self.root
        for i in range(0, len(prefix)):
            ch = prefix[i]
            if cursor.children[ord(ch) - ord('a')] == None:
                return False
            cursor = cursor.children[ord(ch) - ord('a')]

        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)