'''
Accepted on leetcode(208)
time - O(N), space - O(N) where N is length of each word.
Tries are used for string traversal and finding substring. In the implementation of prefix tree, I am using a datastructure TrieNode which consists of endofWord character, value and it's 26 alphabet children.
Inserting word is simple iterate through the word and based on ascii value find the index and insert the alphabet with the endOfWord character.
Search and startswith are similar with a little change, i.e., if found return true else false.
'''


class TrieNode:
    def __init__(self, val):
        self.isEndOfWord = False
        self.children = [None] * 26
        self.val = val


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode("")

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cursor = self.root
        for i in word:
            node = TrieNode(i)
            if cursor.children[ord(i) - ord('a')] == None:
                cursor.children[ord(i) - ord('a')] = node
            cursor = cursor.children[ord(i) - ord('a')]
        cursor.isEndOfWord = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        cursor = self.root
        for i in word:
            if cursor.children[ord(i) - ord('a')] == None:
                return False
            cursor = cursor.children[ord(i) - ord('a')]
        return cursor.isEndOfWord

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        cursor = self.root
        for i in prefix:
            if cursor.children[ord(i) - ord('a')] == None:
                return False
            cursor = cursor.children[ord(i) - ord('a')]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)