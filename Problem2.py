#Time complexity: O(n*l) where n is the number of words in dictionary and l is average length of a word
#Space complexity: O(n*l)

#Accepted on Leetcode

#Approach: 
#DFS based approach 
#Now starting from root perform DFS from right to left(25 to 0 i.e check all children for each node) continuing only if isEnd is true -> at each iteration compare current word with longestWord and replace if length >= longestWord
#Thus for each node we will explore it's depth i.e longest word that can be formed -> then backtrack and check other words and so on
#Hence at the end -> the global 'longestWord' will be the answer -> since we dfs from right to left if lengths of two strings are equal, the lexiographically smaller string will be the longestWord

from collections import deque

class TrieNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isEnd = False


class Trie:
    def __init__(self):
        self.root = None
    
    def insert(self, word):
        if self.root == None:
            self.root = TrieNode()

        root = self.root

        for char in word:
            charCode = ord(char) - ord('a')
            if root.children[charCode] == None:
                root.children[charCode] = TrieNode()
            root = root.children[charCode]

        root.isEnd = True


class Solution:
    def longestWord(self, words: List[str]) -> str:
        #construct trie with all words
        trie = Trie()
        for word in words:
            trie.insert(word)
        
        #globally stored longest word
        self.longestWord = [] #treated as list since strings in python are immutable
        self.curWord = []
        #perform a dfs
        self.dfs(trie.root, self.curWord)

        return ''.join(self.longestWord)

    def dfs(self,root, curWord):
        #base case -> no base case as we enter recursion only if valid case exists

        #logic
        for i in range(25, -1, -1):
            if root.children[i] != None and root.children[i].isEnd:
                #action
                curWord.append(chr(i + 97))
                if len(curWord) >= len(self.longestWord):
                    self.longestWord = [x for x in curWord]
                #recurse
                self.dfs(root.children[i], curWord)
                #backtrack
                curWord.pop()
            
            



