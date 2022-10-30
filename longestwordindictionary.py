##Time Complexity : O(nk)
##Space Complexity : O(n)
##Did this code successfully run on Leetcode : Yes
class TrieNode:
    def __init__(self, value=None):
        self.value = value
        self.isEnd = False
        self.children = [None for i in range(26)]


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        current = self.root
        for i in range(len(word)):
            if current.children[ord(word[i]) - ord('a')] == None:
                current.children[ord(word[i]) - ord('a')] = TrieNode(word[i])
            current = current.children[ord(word[i]) - ord('a')]
        current.isEnd = True


class Solution:
    def longestWord(self, words):
        trie = Trie()
        for i in words:
            trie.insert(i)

        self.result = ''
        for i in range(len(trie.root.children)):
            if trie.root.children[i] and trie.root.children[i].isEnd:
                self.helper_dfs(trie.root.children[i], '')
        return self.result

    def helper_dfs(self, x, temp):
        temp += x.value

        for i in range(len(x.children)):
            if x.children[i] and x.children[i].isEnd == True:
                self.helper_dfs(x.children[i], temp)

        if len(self.result) < len(temp):
            self.result = temp
        
        