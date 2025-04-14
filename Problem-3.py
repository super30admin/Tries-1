'''
    Time Complexity: O(nl)
    Space Complexity: O(nl)
'''
class TrieNode:
    def __init__(self):
        self.children = [None for _ in range(26)]
        self.isEnd = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        cur = self.root

        for char in word:
            index = ord(char) - ord('a')

            if not cur.children[index]:
                cur.children[index] = TrieNode()

            cur = cur.children[index]

        cur.isEnd = True

    def getRoot(self, word):
        cur = self.root
        result = ""

        for char in word:
            index = ord(char) - ord('a')

            if not cur.children[index]:
                return word

            cur = cur.children[index]
            result += char

            if cur.isEnd:
                return result  

        return word

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()

        for word in dictionary:
            trie.insert(word)

        sentenceWords = sentence.split()
        replacedWords = []

        for word in sentenceWords:
            root = trie.getRoot(word)
            if not root:
                print(word)
            replacedWords.append(root)

        # print(replacedWords)

        return " ".join(replacedWords)