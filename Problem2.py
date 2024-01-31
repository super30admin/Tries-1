'''

Time Complexity : O(Lxn)
Space Complexity : O(Lxn)
L - length of the string
n - number of words

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

First we create and insert the word into the Trie. Then we look for the word which follows the requirements of the problem such as having
all the prefixes.

'''


class TrieNode:
    def __init__(self):
        self.child = {}
        self.isEnd = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self,words):
        cur = self.root
        for c in words:
            if c not in cur.child:
                cur.child[c] = TrieNode()
            cur = cur.child[c]
        cur.isEnd = True


    def longest(self,words):
        res = ""

        for word in words:
            word = list(word)

            cur = self.root
            x = True

            for c in word[:len(word)-1]:
                if c not in cur.child:
                    x = False
                    break
                cur = cur.child[c]
                if cur.isEnd is False:
                    x = False
                    break


            if x:
                word = ''.join(word)

                if len(word) > len(res) or (len(word) == len(res) and word < res):
                    res = word

        return res




class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        words.sort()

        for word in words:
            trie.insert(word)

        return trie.longest(words)