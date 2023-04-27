# Time Complexity: O(kn) where k is the length of the longest word and n is the number of words in the dictionary
# Space Complexity: O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We create a Trie with the words in the dictionary. We then perform a DFS on the Trie and keep track of the longest word
"""

class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None for i in range(26)]
            self.isEnd = False

    def __init__(self):
        self.root = self.TrieNode()

    def insert_words(self, word):
        node = self.root
        for char in word:
            index = ord(char) - ord('a')
            if node.children[index] == None:
                node.children[index] = self.TrieNode()
            node = node.children[index]
        node.isEnd = True

    def dfs(self, node, current):
        for i in range(26):
            if node.children[i] and node.children[i].isEnd:
                current.append(chr(ord('a') + i))
                print(current)
                if len(current) > len(self.answer) or (len(current) == len(self.answer) and ''.join(current) < self.answer):
                    self.answer = ''.join(current)
                self.dfs(node.children[i], current)

                current.pop()
            
    def longestWord(self, words: List[str]) -> str:
        if words == None or len(words) == 0: return []
        for word in words: self.insert_words(word)
        self.answer = ''
        current = []
        self.dfs(self.root, current)

        return self.answer
