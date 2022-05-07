# Time Complexity: O(m * k) + O(n * l)
#   m = # of elements in dictionary
#   k = average length of a word in dictionary
#   n = # of elements in sentence
#   l = average length of a word in sentence

# Space Complexity: O(m) for storing dictionary words in a Trie
# Did this run successfully on Leetcode: Yes
# Any problems faced while coding: took some time to get the correct solution


class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

class Solution:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c) - ord('a')] is None:
                curr.children[ord(c) - ord('a')] = TrieNode()
            curr = curr.children[ord(c) - ord('a')]
        curr.isEnd = True

    def replaceWords(self, dictionary, sentence):
        self.root = TrieNode()
        for word in dictionary:
            self.insert(word)
        result = []
        splitArr = sentence.split(" ")
        for j in range(len(splitArr)):
            if j != 0:
                result.append(" ")
            curr = self.root
            replacement = []
            word = splitArr[j]
            for i in range(len(word)):
                c = word[i]
                if curr.children[ord(c) - ord('a')] is None or curr.isEnd:
                    break
                replacement.append(c)
                curr = curr.children[ord(c) - ord('a')]
            if curr.isEnd:
                result.append("".join(replacement))
            else:
                result.append(word)
        return "".join(result)

