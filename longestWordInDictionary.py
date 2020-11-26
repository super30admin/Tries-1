#Time Complexity : O(m*n) where m is the average length of the words and n is the total number of words
#Space Complexity : O(m*n) where m is the average length of the words and n is the total number of words
#Did this code successfully run on Leetcode : Yes

class TrieNode:
    def __init__(self, word=None):
        self.children = [None] * 26
        self.word = word

class Solution:
    def longestWord(self, words: List[str]) -> str:
        self.root = TrieNode()
        #insert words into the trie, adding the entire word to each node if the prefix exists
        for word in words:
            curr = self.root
            for char in word:
                if curr.children[ord(char)-ord("a")] is None:
                    curr.children[ord(char)-ord("a")] = TrieNode()
                curr = curr.children[ord(char)-ord("a")]
            curr.word = word

        #perform BFS
        q = deque([self.root])
        while q:
            curr = q.popleft()
            #iterate through all the children of the curr node in reverse order
            for i in range(25, -1, -1):
                if curr.children[i] and curr.children[i].word:
                    q.append(curr.children[i])

        return curr.word
