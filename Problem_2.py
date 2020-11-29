"""
Time Complexity : O(m*n) where n is number of words and m is average length of words 
Space Complexity : O(m*n) where n is number of words and m is average length of words - worst case
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
Here, we will first insert all the words inside Trie. After that we would be doing BFS on the root node.
We add one by one all the children node from root to the queue, but only those whose word is not None. Also, we 
do this process starting from last index. This way, we will get lexographically smaller word with largest length.

"""


class TrieNode:
    def __init__(self, word=None):
        self.children = [None] * 26
        self.word = word


class Solution:
    def longestWord(self, words: List[str]) -> str:
        self.root = TrieNode()
        for word in words:
            curr = self.root
            for char in word:
                if curr.children[ord(char)-ord("a")] is None:
                    curr.children[ord(char)-ord("a")] = TrieNode()
                curr = curr.children[ord(char)-ord("a")]
            curr.word = word

        q = deque([self.root])
        while q:
            curr = q.popleft()
            for i in range(25, -1, -1):
                if curr.children[i] and curr.children[i].word:
                    q.append(curr.children[i])

        return curr.word
