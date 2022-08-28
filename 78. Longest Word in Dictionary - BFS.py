from collections import deque


class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.word = None


class Solution:
    def insert(self, word):
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            if not curr.children[ord(ch) - ord("a")]:
                curr.children[ord(ch) - ord("a")] = TrieNode()
            curr = curr.children[ord(ch) - ord("a")]
        curr.word = word
        # print(curr.word)

    def longestWord(self, words: List[str]) -> str:
        self.root = TrieNode()
        for word in words:
            # print(word)
            self.insert(word)

        q = deque()
        q.append(self.root)
        curr = TrieNode()
        while len(q) > 0:
            curr = q.popleft()
            # print(curr.children)
            for i in range(25, -1, -1):
                if curr.children[i] != None and curr.children[i].word != None:
                    q.append(curr.children[i])
                    # print(q)

        if not curr.word:
            return ""

        return curr.word

# TC =O(nk).
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
