class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26


class Solution:
    # Time Complexity : O(len(Word))
    # Space Complexity : O(len(Word))
    def insert(self, word):
        curr = self.root
        for char in word:
            key = ord(char) - ord('a')
            if not curr.children[key]:
                curr.children[key] = TrieNode()
            curr = curr.children[key]
        curr.isEnd = True

    # Time Complexity : O(nk + len(words))
    # Space Complexity : O(nk)
    def longestWord(self, words: List[str]) -> str:
        if not words:
            return ''
        self.root = TrieNode()

        # (nk)
        for word in words:
            self.insert(word)

        self.result = []
        self.backtrack(self.root, [])
        return ("").join(self.result)

    def backtrack(self, root, result):
        # base
        if len(result) > len(self.result):
            self.result = list(result)

        # logic
        for i in range(26):
            if (root.children[i] and root.children[i].isEnd == True):
                # action
                result.append(chr(i + ord('a')))
                # print(result)

                self.backtrack(root.children[i], result)

                # backtrack
                result.pop()
        return
