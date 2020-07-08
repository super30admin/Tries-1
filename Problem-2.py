# Time Complexity :O(summation of lengths of words)
# Space Complexity :O(summation of lengths of words)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
from collections import deque
class Solution(object):
    # create node class
    class Node():
        def __init__(self):
            self.children = {}
            self.endOfWord = None
    #create Trie
    class Trie(object):

        def __init__(self):
            """
            Initialize your data structure here.
            """
            self.root = Solution.Node()
        # insert function
        def insert(self, word):
            """
            Inserts a word into the trie.
            :type word: str
            :rtype: None
            """
            iterator = self.root
            for i in word:
                if i not in iterator.children:
                    iterator.children[i] = Solution.Node()
                iterator = iterator.children[i]
            iterator.endOfWord = word
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        # create Trie instance
        myTrie = Solution.Trie()
        # insert all words
        for i in words:
            myTrie.insert(i)
        # create deque and append root to it
        queue = deque()
        queue.append(myTrie.root)
        #dfs
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                #check all children of current sorted in reverse order
                keys = sorted(curr.children.keys(),reverse=True)
                for key in keys:
                    # if letter in children is end of word add it to queue
                    if curr.children[key].endOfWord:
                        queue.append(curr.children[key])
        #return the longest word with all prefixes in words array with letter in end of alphabet
        return curr.endOfWord
        