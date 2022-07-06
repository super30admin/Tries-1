"""
Leetcode-https://leetcode.com/problems/longest-word-in-dictionary/
TC- O(2*N*K) for traversal and adding words, SC- O(N) for trie
Challenges-Coming up with how to traverse all possible words in Trie
Lecture-https://www.youtube.com/watch?v=C8VRMbEgOqc (similar problems lecture)
FAQ-


Given an array of strings words representing an English Dictionary, return the longest word in words that can be built
one character at a time by other words in words.

If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is
no answer, return the empty string.


Example 1:
Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Example 2:
Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".


Constraints:
1 <= words.length <= 1000
1 <= words[i].length <= 30
words[i] consists of lowercase English letters.
"""


class TrieNode():
    def __init__(self):
        self.val = None
        self.children = [None] * 26
        self.isEnd = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for char in word:
            ci = ord(char) - ord('a')
            if curr.children[ci] is None:
                curr.children[ci] = TrieNode()
                curr.children[ci].val = char
            curr = curr.children[ci]

        curr.isEnd = True


class Solution:
    """
    Ideation- Trie solution, TC- O(2*N*K) for traversal and adding words, SC- O(N) for trie

    Step 1- Put all the words in a Trie.
    Step 2- Traverse through Trie to find the longest word - Traverse through all possible words/path and check if
    they are longer than current result.

    To find the longest word, all the parents of the child should be true which would mean that its prefix's exists in tree like the problem states.
    """

    def longestWord(self, words):
        trie = self.implementTrie(words)
        self.result = ''
        self.dfs(trie.root, 0, [])
        return self.result

    # traverse trie
    def dfs(self, root, level, path):
        # base1 - no node
        if root is None:
            return
        # if we found a result longer than current
        if level > len(self.result):
            self.result = ''.join(path)
        # logic
        for child in root.children:
            # all children signify tries inside them and are node in our paths, and if they are complete words (isEnd),
            # then only they are considered to match against our current longest word.
            if child is not None and child.isEnd is True:
                # action
                path.append(child.val)
                self.dfs(child, level + 1, path)
                # backtrack
                path.pop()

    # implement trie with given words
    def implementTrie(self, words):
        trie = Trie()
        for word in words:
            trie.insert(word)
        return trie

    """
    Ideation- Brute force - O(NlogN * K), where K is length of word.
    Sort words list in descending order and check if word[:k] exits in the list from k: 1 to  word length.
    wordset is hashset the lookup of word in it O(1).
    """

    def longestWord1(self, words):
        wordset = set(words)
        words.sort(key=lambda c: (-len(c), c))
        for word in words:
            if all(word[:k] in wordset for k in range(1, len(word))):
                return word

        return ""
