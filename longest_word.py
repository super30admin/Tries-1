#Time Complexity:O(mn) 
#Space Complexity:O(mn)
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach: Trie + BFS
# Insert all the words in a Trie and traverse the trie in BFS fashion. Traverse from right to left to obtain lexicographically smallest word in the end.

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.word = None


class Solution:
    def insert(self, word):
        curr = self.root
        for char in (word):
            if curr.children[ord(char) - ord('a')] == None:
                curr.children[ord(char) - ord('a')] = TrieNode()
                
            curr = curr.children[ord(char) - ord('a')]
        
        curr.word = word

    def longestWord(self, words: List[str]) -> str:

        if not words or len(words) == 0:
            return ""

        self.root  = TrieNode()

        for word in words:
            self.insert(word)

        queue = collections.deque()
        curr = self.root
        queue.append(self.root)

        while queue:
            curr = queue.popleft()
            for i in range(len(curr.children) - 1, -1, -1):
                if curr.children[i] != None and curr.children[i].word != None:
                    queue.append(curr.children[i])

        if curr is None:
            return ""

        return curr.word