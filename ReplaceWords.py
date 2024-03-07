'''
TC: O(N*M + L*K) where N is the number of characters in a word
                M is the number of words
                L is the length of the longest word
                K is the number of words in the input string
SC: O(N*M + L) - L for the recursion depth and N*M is the complexity
                    to build the Trie for every node
'''
from typing import List

class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.flag = False
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.head = TrieNode()

        def insertTrie(word):
            pointer = self.head
            for letter in word:
                order = ord(letter)-ord('a')
                if pointer.children[order]==None:
                    pointer.children[order] = TrieNode()
                pointer = pointer.children[order]
            pointer.flag = True

        for word in dictionary:
            insertTrie(word)
        

        def dfs(root, word, myword, word_i):
            if not root:
                return
            if root.flag:
                self.res += myword
                return
            for i, element in enumerate(root.children):
                if element and word_i<len(word) and chr(i+ord('a')) == word[word_i]:
                    dfs(element, word, myword+chr(i+ord('a')), word_i+1)
                    
        self.res = ""
        pointer = self.head
        ans = ""
        wordList = sentence.split(' ')
        for i,word in enumerate(wordList):
            self.res = ""
            dfs(pointer, word, "", 0)
            ans += word if self.res == "" else self.res
            if i != len(wordList)-1:
                ans += " "
        return ans
s = Solution()
print(s.replaceWords(["cat","bat","rat"], "the cattle was rattled by the battery"))
print(s.replaceWords(["a","b","c"], "aadsfasf absbs bbab cadsfafs"))