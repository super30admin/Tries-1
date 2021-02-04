# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Using BFS Approach. Insert characters of words in Trie
# Initialize a queue with root and check if the root has children and it has word then append to queue
# Pop the queue and check if it has children and word and append to the queue
# Check if the len of the word is greater than current word in res then update res to new word

from collections import deque
from collections import defaultdict


class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.word = ""


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        currentNode = self.root
        for i in range(len(word)):
            c = word[i]
            if c not in currentNode.children:
                currentNode.children[c] = TrieNode()
            currentNode = currentNode.children[c]
        currentNode.word = word

    def bfs(self):
        queue = deque([self.root])
        res = ''
        while queue:
            currentNode = queue.popleft()
            for n in currentNode.children.values():
                if n.word:
                    queue.append(n)
                    if len(n.word) > len(res) or n.word < res:
                        res = n.word
        return res


class Solution:
    def longestWord(self, words: List[str]) -> str:
        if not words:
            return ""
        rootNode = Trie()
        for word in words:
            rootNode.insert(word)
        return rootNode.bfs()
