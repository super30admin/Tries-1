# Time Complexity : O(n*k)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#

# Using DFS
class TrieNode:
    def __init__(self, val=None):
        self.letter = val
        self.children = [None] * 26
        self.flag = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, words):
        for w in words:
            word = w
            temp = self.root
            for letter in word:
                index = ord(letter) - ord('a')
                if not temp.children[index]:
                    temp.children[index] = TrieNode(letter)
                temp = temp.children[index]
            temp.flag = True
        return self.root


class Solution:
    def dfs(self, root, path):
        # base
        if len(self.result) < len(path):
            self.result = path[:]
        # logic
        for temp in root.children:
            if temp and temp.flag:
                path.append(temp.letter)
                self.dfs(temp, path)
                # back-track
                path.pop()

    def longestWord(self, words: list[str]) -> str:
        trie = Trie()
        self.result = []
        root = trie.insert(words)
        self.dfs(root, [])
        return ''.join(self.result)


print(Solution().longestWord(["a", "banana", "app", "appl", "ap", "apply", "apple"]))


# using bfs
# from collections import deque


# class TrieNode:
#     def __init__(self, val=None):
#         self.letter = val
#         self.children = [None] * 26
#         self.flag = False


# class Trie:
#     def __init__(self):
#         self.root = TrieNode()

#     def insert(self, words):
#         for w in words:
#             word = w
#             temp = self.root
#             for letter in word:
#                 index = ord(letter) - ord('a')
#                 if not temp.children[index]:
#                     temp.children[index] = TrieNode(letter)
#                 temp = temp.children[index]
#             temp.flag = True
#         return self.root


# class Solution:
#     def longestWord(self, words: list[str]) -> str:
#         trie = Trie()
#         self.result = []
#         root = trie.insert(words)
#         queue = deque()
#         queue2 = deque()
#         pop2 = ''
#         for i in range(25, -1, -1):
#             if root.children[i] and root.children[i].flag:
#                 queue.append(root.children[i])
#                 queue2.append(root.children[i].letter)
#         while queue and queue2:
#             pop = queue.popleft()
#             pop2 = queue2.popleft()
#             for i in range(25, -1, -1):
#                 if pop.children[i] and pop.children[i].flag:
#                     queue.append(pop.children[i])
#                     pop1 = pop2 + pop.children[i].letter
#                     queue2.append(pop1)
#         return pop2
#
#
# print(Solution().longestWord(["a", "banana", "app", "appl", "ap", "apply", "apple"]))
