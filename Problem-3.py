"""
Approach:
1) add all root words to Trie
2) Traverse through the sentence and try to find the root words
    a) if a word is not a root word add it to your result as is
    b) if a root word is found, add it to result instead of the given word/successor
TC: O(kn) + O(m) where k = average length of root words, n = number of root words, m = len of sentence
SC: O(n) + O(m) + O(L)
    you split the sentence into an array - O(m)
    you store the root chars in Trie - O(n)
    you store the current root word while traversing - O(L)
"""

class TrieNode:
    def __init__(self):
        self.next = [None] * 26
        self.isEnd = False


class Solution:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for char in word:
            if curr.isEnd:
                break
            if not curr.next[ord(char) - ord('a')]:
                curr.next[ord(char) - ord('a')] = TrieNode()
            curr = curr.next[ord(char) - ord('a')]
        curr.isEnd = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        result = []

        # put all root words into Trie
        for word in dictionary:
            self.insert(word)

        # search for root words in the sentence
        for word in sentence.split(" "):
            curr = self.root
            curr_word = []
            for char in word:
                if not curr.next[ord(char) - ord('a')]:  # if prefix is not matching root a word, stop going further
                    break
                curr = curr.next[ord(char) - ord('a')]
                curr_word.append(char)  # keep track of the root word
                if curr.isEnd:
                    result.append("".join(curr_word))  # if root word found add to result
                    break
            if not curr.isEnd: result.append(word)  # if root word not found add actual word/successor
        return " ".join(result)
