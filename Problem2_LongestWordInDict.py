# Time Complexity: O(mn), where m - num of words, n - average length of words
# Space Complexity: O(mn)
# Did this code successfully run on Leetcode: Yes

# Solution:

class TrieNode:
    def __init__(self):
        self.word = ""
        self.children = [None for x in range(26)]


class Solution:
    def longestWord(self, words: List[str]) -> str:
        if not words or len(words) == 0:
            return ""

        self.root = TrieNode()

        # Insert all words into the Trie
        for word in words:
            self.insert(word)

        # Traverse using BFS from right to left
        q = deque()
        q.append(self.root)
        while q:
            curr = q.popleft()
            for i in range(25, -1, -1):
                if curr.children[i] and curr.children[i].word:
                    q.append(curr.children[i])

        # Return the word associated with the last char from the queue
        return curr.word

    def insert(self, word: str) -> None:
        curr = self.root
        for ch in word:
            if not curr.children[ord(ch) - ord('a')]:
                curr.children[ord(ch) - ord('a')] = TrieNode()
            curr = curr.children[ord(ch) - ord('a')]
        curr.word = word

