'''
Time Complexity: O(n*l)
Space Complexity: O(n*l)
Did this code successfully run on Leetcode : Yes
Explanation: Insert all new possible words to the Trie and for  each old word in sentence, check whether any subword is
present in the Trie as a word and if present replace the sub-word with the old word and otherwise leave the old-word as is.
'''


class TrieNode:
    def __init__(self):
        self.word = None
        self.children = [None] * 26
        self.isEndOfWord = False


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cursor = self.root
        for i in range(0, len(word)):
            ch = word[i]
            if cursor.children[ord(ch) - ord('a')] == None:
                cursor.children[ord(ch) - ord('a')] = TrieNode()
            cursor = cursor.children[ord(ch) - ord('a')]
        cursor.isEndOfWord = True
        cursor.word = word

    def replaceWords(self, sentence) -> str:
        res = []
        # We need to use dequeue and popleft to main lexographic
        # "apply", "apple" should return apple
        wordList = sentence.split(' ')
        cursor = ''
        for word in wordList:
            cursor = self.root
            for i in range(0, len(word)):
                ch = word[i]

                if cursor.children[ord(ch) - ord('a')] == None or cursor.word != None:
                    break
                cursor = cursor.children[ord(ch) - ord('a')]

            newWord = cursor.word

            if newWord == None:
                res.append(word)
            else:
                res.append(newWord)

        return ' '.join(res)


class Solution:
    def replaceWords(self, dict1: List[str], sentence: str) -> str:
        root = Trie()
        for word in dict1:
            root.insert(word)

        return root.replaceWords(sentence)

