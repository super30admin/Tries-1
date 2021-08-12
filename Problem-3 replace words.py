# TC:O(MK+N),M=lenght of dictionary, K=length of longest word in dictionary,N=length of sentence
# SC:O(MK)
class TrieNode:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.isEnd = False
        self.children = [None for i in range(26)]


class Solution:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word: str) -> None:  # TC:O(L)
        # SC:O(L)
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            if curr.children[ord(ch) - ord('a')] == None:
                curr.children[ord(ch) - ord('a')] = TrieNode()
            curr = curr.children[ord(ch) - ord('a')]

        curr.isEnd = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:

        if dictionary == None or len(dictionary) == 0:
            return sentence

        for word in dictionary:
            self.insert(word)

        arrays = sentence.split()
        result = []

        for word in arrays:
            replace = ""
            curr = self.root
            for i in range(len(word)):
                ch = word[i]
                if curr.children[ord(ch) - ord('a')] == None or curr.isEnd:
                    break
                curr = curr.children[ord(ch) - ord('a')]
                replace += ch
            if curr.isEnd:
                result.append(replace)
            else:
                result.append(word)

        return " ".join(result)

