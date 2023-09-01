from collections import deque


class TrieNode(object):

    def __init__(self):
        self.children = [None for i in range(26)]
        self.word = None


class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):

        currNode = self.root

        for i in range(len(word)):
            currChar = word[i]
            if (currNode.children[ord(currChar) - ord('a')] == None):
                currNode.children[ord(currChar) - ord('a')] = TrieNode()
            currNode = currNode.children[ord(currChar) - ord('a')]

        currNode.word = word


class LongestWord(object):
    def longestWord(self, words):

        trie = Trie()

        for word in words:
            trie.insert(word)

        queue = deque([trie.root])

        max_word = None

        while (len(queue) > 0):

            size = len(queue)

            for i in range(size):
                currNode = queue.popleft()
                max_word = currNode.word
                for j in range(25, -1, -1):
                    if (currNode.children[j] != None and currNode.children[j].word != None):
                        queue.append(currNode.children[j])

        return max_word