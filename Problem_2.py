class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None for i in range(26)]
            self.word = None

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur = self.root
        for i in range(len(word)):
            c = word[i]
            if cur.children[ord(c) - 97] == None:
                cur.children[ord(c) - 97] = self.TrieNode()
            cur = cur.children[ord(c) - 97]
        cur.word = word

    """
    BFS IMplementation with Trie
    TC - O(nk)
    SC - O(nk)
    """

    def longestWord(self, words: List[str]) -> str:
        if not words:
            return ""
        self.root = self.TrieNode()
        for word in words:
            self.insert(word)
        q = []
        curr = self.root
        q.append(self.root)
        while len(q) > 0:
            cur = q.pop(0)
            for i in range(25, -1, -1):
                if cur.children[i] != None and cur.children[i].word != None:
                    q.append(cur.children[i])
        if cur.word == None:
            return ""
        return cur.word
