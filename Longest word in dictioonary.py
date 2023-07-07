# Time complexity : O(n*L), n is number of words and L is average length of each word
# Space complexity : O(size of dictionary) to store the trie
# The code ran on Leetcode

# Keep adding new elements to the trie node and update the res when we reach a longer string. If two strings have same length, only store the lexicographically smaller string.

class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.EoW = False

class Trie:
    def __init__(self):
        self.root = TrieNode()


    def new(self, word):
        cur = self.root
        flag = True
        height = 0; char = ''
        for i in range(len(word)):
            w = word[i]
            idx = ord(w) - ord('a')
            if cur.children[idx] == None:
                cur.children[idx] = TrieNode()
                if flag and i == len(word) - 1:
                    height+=1
                    char += w
                else:
                    flag = False
            else:
                if cur.children[idx].EoW == True and flag:
                    height+=1
                    char += w
                else:
                    flag = False
            cur = cur.children[idx]
        cur.EoW = True
        return char

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        res = ''
        words.sort(key = lambda x : len(x))
        
        for word in words:
            char = trie.new(word)
            if len(char) > len(res):
                res = char
            elif len(char) == len(res) and char < res:
                res = char
        return res