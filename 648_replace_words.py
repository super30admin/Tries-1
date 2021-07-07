from typing import List


class Solution:
    """
        https://leetcode.com/problems/replace-words/
    """
    """
        // Time Complexity : O(m*n + m1 * n1)
            'm' words, 'n' avg len of the word, 
            'm1' words in sentence, 'n1' avg len of word in setence,
        // Space Complexity : O(w)
            'w' is the no of unique characters in all words in dic
    """

    class Node:
        def __init__(self):
            self.children = [None] * 26
            self.word = None

    def __init__(self):
        self.root = self.Node()

    def insert(self, word):
        cur = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if cur.children[idx] is None:
                cur.children[idx] = self.Node()
            cur = cur.children[idx]
        cur.word = word

    def search(self, word):
        cur = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if cur.children[idx]:
                cur = cur.children[idx]
                if cur.word:
                    return cur.word
            else:
                break
        return word

    def replaceWords(self, dict: List[str], sentence: str) -> str:

        for word in dict:
            self.insert(word)

        output = ''
        for word in sentence.split():
            if len(output) > 0:
                output += ' '
            output += self.search(word)
        return output
