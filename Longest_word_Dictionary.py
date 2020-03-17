// Time Complexity : o(summation(m*L)) m is length of the word and L is the length of the trienode children
// Space Complexity : o(summation(m*L)) to create the trie using all the words
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we created a trie which contains the word with its children.when a node is inserted we will have the value and the total word from root to that value.we used BFS in this problem .when the queue is empty we get the longest word in the dictionary.


class TrieNode:
    def __init__(self):
        self.word1=None
        self.children=[None for i in range(26)] 

class Trie(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root=TrieNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        root1=self.root
        for i in range(len(word)):
            index=ord(word[i])-ord('a')
            if root1.children[index]==None:
                root1.children[index]=TrieNode()
            root1=root1.children[index]
        root1.word1=word
from collections import deque
class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        trie=Trie()
        root1=trie.root
        for word in words:
            trie.insert(word)
        queue=deque([root1])
        while len(queue)!=0:
            q=queue.popleft()
            # we do this to maintain lexiographic order.
            for i in range(25,-1,-1):
                if q.children[i]!=None and q.children[i].word1!=None:
                    queue.append(q.children[i])
        return q.word1
            
        
        