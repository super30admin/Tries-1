'''
Time: O(N*k) ~ O(k) -> length of largest word k and n is number of words
Space: O(N*k) -> Overall for length of word and length of largest word
Did this code successfully run on Leetcode : Yes
Explanation: Insert words and in each word u insert, the last character of the word in the Trie contains the complete
Word. Iterate through the trie till you find the longest word in the dictionary

Iterate through children from back to main lexographic order
'''


class TrieNode:
    def __init__(self):
        self.word = None
        self.children = [None] * 26
        self.isEndOfWord = False


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
        cursor = self.root
        for i in range(0, len(word)):
            ch = word[i]
            if cursor.children[ord(ch) - ord('a')] == None:
                cursor.children[ord(ch) - ord('a')] = TrieNode()
            cursor = cursor.children[ord(ch) - ord('a')]
        cursor.isEndOfWord = True
        cursor.word = word

    def longestWord(self) -> str:

        # We need to use dequeue and popleft to main lexographic
        # "apply", "apple" should return apple
        queue = [self.root]
        while len(queue) != 0:
            cursor = queue[0]
            queue = queue[1:]

            for i in range(25, -1, -1):
                if cursor.children[i] != None and cursor.children[i].word != None:
                    queue.append(cursor.children[i])

        return cursor.word


class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()

        for word in words:
            trie.insert(word)

        return trie.longestWord()
