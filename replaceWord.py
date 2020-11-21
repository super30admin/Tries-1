#Time Complexity : O(n*p) where n is the length of the sentence and p is the average length of the word in each dictionary
#Space Complexity : O(m) where m is the size of our trie.
#Did this code successfully run on Leetcode : Yes

class Solution:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = {}

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        t = self.root
        for char in word:
            if char not in t:
                t[char] = {}
            t = t[char]
        t['isEnd'] = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        t = self.root
        prefix = []
        for char in word:
            if char not in t or 'isEnd' in t:
                break
            prefix.append(char)
            t = t[char]
        if 'isEnd' in t:
            return prefix
        else:
            return []


    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
            self.insert(word)

        result = []
        for i, word in enumerate(sentence.split()):
            if i > 0:
                result.append(" ")
            prefix = self.search(word)
            if len(prefix) > 0:
                result.append("".join(prefix))
            else:
                result.append(word)

        return "".join(result)
