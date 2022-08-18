"""
Runtime Complexity:
O(n*l) - where 'n' is the number of words and 'l' is the average length of thr words.
Space Complexity:
O(n*l) - Although each children can hold only 26 space but still the trie stores 'n' words. Therefore on average n*l
Yes, the code worked on leetcode.
"""


class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.word = ""



class Solution:
    def __init__(self):
        self.root = TrieNode()


    def insert(self, word):
        curr = self.root
        for char in word:
            c = ord(char) - ord('a')
            if curr.children[c] == None:
                curr.children[c] = TrieNode()

            curr = curr.children[c]
        curr.word = word

    def longestWord(self, words: List[str]) -> str:

        if words == None:
            return ""

        for word in words:
            self.insert(word)

        
        st = ""
        queue = []
        queue.append(self.root)

        while(queue):
            curr = queue.pop(0)
        
            for i in range(25, -1, -1):
                if curr.children[i] != None and curr.children[i].word != "":
                    queue.append(curr.children[i])

        return curr.word 