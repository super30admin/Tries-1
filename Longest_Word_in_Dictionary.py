class TrieNode:
    def __init__(self):
        self.word = None
        self.children = [None] * 26


class Solution:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for c in word:
            if not curr.children[ord(c) - ord('a')]:
                curr.children[ord(c) - ord('a')] = TrieNode()
            curr = curr.children[ord(c) - ord('a')]
        curr.word = word

    def longestWord(self, words: List[str]) -> str:
        if not words:
            return ""

        q = deque()

        for word in words:
            self.insert(word)

        q.append(self.root)

        while q:
            curr = q.popleft()
            for i in range(25, -1, -1):
                if curr.children[i] and curr.children[i].word:
                    q.append(curr.children[i])

        return curr.word

