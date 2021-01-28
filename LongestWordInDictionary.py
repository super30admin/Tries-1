'''
Solution:
1.  Insert all new possible words to the Trie.
2.  Maintain a queue which adds words (Trie Nodes) at each level.
3.  Return the last popped element from the Queue as the maximum length word.

Time Complexity:    O(n * L)    n is no. of words and L is max length of one word
Space Complexity:   O(n * L)    max space occupied by the Trie

--- Passed all testcases on Leetcode successfully
'''


from collections import deque


class TrieNode(object):

    def __init__(self):
        self.children = [None for i in range(26)]
        self.word = None


class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):

        #   function to insert a word in a Trie data structure

        #   initialize to the root of the trie as current node
        currNode = self.root

        #   traverse the trie until we hit the length of word to be inserted
        for i in range(len(word)):
            currChar = word[i]
            if (currNode.children[ord(currChar) - ord('a')] == None):
                currNode.children[ord(currChar) - ord('a')] = TrieNode()
            currNode = currNode.children[ord(currChar) - ord('a')]

        currNode.word = word


class LongestWord(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        #   initialize a Trie
        trie = Trie()

        #   insert all words to a Trie present in the dict
        for word in words:
            trie.insert(word)

        #   initialize a queue containing Trie Nodes with the Trie's root
        queue = deque([trie.root])

        #   initialize a maximum length word
        max_word = None

        while (len(queue) > 0):

            #   iterate until size to maintain the level
            size = len(queue)

            #   for all Trie Nodes which are words at a level, append only those child Trie Nodes which are words again.
            for i in range(size):
                currNode = queue.popleft()
                max_word = currNode.word
                #   iterate in the reverse order to maintain lexicographic order
                for j in range(25, -1, -1):
                    if (currNode.children[j] != None and currNode.children[j].word != None):
                        queue.append(currNode.children[j])

        return max_word