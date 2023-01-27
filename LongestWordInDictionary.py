#Time Complexity: O(n*l)
#Space Complexity: O(n*l)
#successfully ran on leetcode

class Solution:
    class TrieNode:
        def __init__(self):
            self.word = None
            self.children = [None]*26
    def __init__(self):
        self.root = self.TrieNode()
    def insert(self,word):
        curr = self.root
        for i in word:
            if not curr.children[ord(i)-ord('a')]:
                curr.children[ord(i)-ord('a')] = self.TrieNode()
            curr = curr.children[ord(i)-ord('a')]
        curr.word =word
    def longestWord(self, words: List[str]) -> str:
        if len(words)==0:
            return ""
        for i in words:
            self.insert(i)
        queue = [self.root]
        while queue:
            curr = queue.pop(0)
            for i in range(25,-1,-1):
                if curr.children[i] and curr.children[i].word:
                    queue.append(curr.children[i])
        return curr.word if curr.word else ""