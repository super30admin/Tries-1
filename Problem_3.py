
"""
Time Complexity : O(mp + np)- where m is number of words in dictionary with length p and n is number
of words in the sentence with length p  
Space Complexity : O(mp) where m is number of words in dictionary with length p 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
Here, we have implemented Trie again and added another function for searching the minimum prefix availale.
So, after inserting the values inside the trie, we will split the senetence into a list and traverse all
the characters of all the words one by one. For checking, we check if we reached a word ending or a 
particular character was not present. In that case we need to stop there, otherwise, we keep on concatinating
the character to a replacement string. If we reached end of a word, we have return that replacement, otherwis
there is no replacement present.
"""


class TrieNode:
    def __init__(self):
        self.children = {}
        self.isend = False


class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for w in word:
            if w not in node.children:
                node.children[w] = TrieNode()
            node = node.children[w]
        node.isend = True

    def search(self, word):
        node = self.root
        replacement = ""
        for w in word:
            if (w not in node.children) or (node.isend):
                break
            replacement += w
            node = node.children[w]
        if node.isend:
            return replacement
        else:
            return word


class Solution:

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:
            trie.insert(word)
        result = []
        temp = sentence.split()
        for t in temp:
            value = trie.search(t)
            result.append(value)
        return ' '.join(result)
