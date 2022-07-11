#Trie-DFS
""""// Time Complexity : O(nk)
// Space Complexity : O(RecursiveStack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class TrieNode:
    def __init__(self, val=None):
        self.val = val
        self.isEnd = False
        self.children = [None for i in range(26)]


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            if curr.children[ord(word[i]) - ord('a')] == None:
                curr.children[ord(word[i]) - ord('a')] = TrieNode(word[i])
            curr = curr.children[ord(word[i]) - ord('a')]
        curr.isEnd = True


class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for i in words:
            trie.insert(i)

        self.result = ''
        for i in range(len(trie.root.children)):
            if trie.root.children[i] and trie.root.children[i].isEnd:
                self.helper_dfs(trie.root.children[i], '')
        return self.result

    def helper_dfs(self, x, temp):
        temp += x.val

        for i in range(len(x.children)):
            if x.children[i] and x.children[i].isEnd == True:
                self.helper_dfs(x.children[i], temp)

        if len(self.result) < len(temp):
            self.result = temp

#Trie-BFS
# class TrieNode:
#     def __init__(self, val=None):
#         self.val = val
#         self.isEnd = False
#         self.children = [None] * 26
#
#
# class Trie:
#     def __init__(self):
#         self.root = TrieNode()
#
#     def insert(self, word: str) -> None:
#         curr = self.root
#         for i in range(len(word)):
#             if curr.children[ord(word[i]) - ord('a')] == None:
#                 curr.children[ord(word[i]) - ord('a')] = TrieNode(word[i])
#             curr = curr.children[ord(word[i]) - ord('a')]
#         curr.isEnd = True
#
#
# class Solution:
#     def longestWord(self, words: List[str]) -> str:
#         trie = Trie()
#         for i in words:
#             trie.insert(i)
#         q1 = deque()
#         q2 = deque()
#
#         q1.append(trie.root)
#         self.result = ''
#         if self.result:
#             self.result += trie.root.val
#         q2.append(self.result)
#
#         while q1 and q2:
#             x = q1.popleft()
#             y = q2.popleft()
#             temp = y
#             for i in range(25, -1, -1):
#                 if x.children[i] != None and x.children[i].isEnd == True:
#                     q1.append(x.children[i])
#                     y += x.children[i].val
#                     q2.append(y)
#                     y = temp
#
#         return y











