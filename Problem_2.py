"""
Problem : 2

Time Complexity : O(nk)
Space Complexity : O(nk)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Creating a TrieNode, then inserting all the words in the trieNode, using bfs to traverse through the trie and building the
result string, starting from the farthest right, as the lexicographically smallest character will be iterated at the very end
finally returns the last string obtained from the BFS traversal, which represents the longest word in the dictionary.

"""

# Longest Word in Dictionary

class TrieNode(object):
        def __init__(self):
            self.children=[None for _ in range(26)]
            self.isEnd=False

class Solution(object):
    def __init__(self):
        self.root=TrieNode()

    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        curr=self.root
        for i in range(len(word)):
            c=word[i]
            index=ord(c)-ord('a')
            if curr.children[index]==None:
       
                curr.children[index]=TrieNode()
            
            curr=curr.children[index]
        curr.isEnd=True

    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        for word in words:
            self.insert(word)
        
        q=collections.deque()
        sq=collections.deque()

        q.append(self.root)
        sq.append("")
        currStr=""
        while q:
            curr=q.popleft()
            currStr=sq.popleft()
            for i in range(25,-1,-1):
                child=curr.children[i]
                if child and child.isEnd:
                    q.append(child)
                    st=currStr+chr(ord('a')+i)
                    sq.append(st)

        return currStr
