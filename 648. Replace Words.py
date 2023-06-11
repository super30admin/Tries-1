#Time Complexity:O(n+m(average size of the word))
#Space Complexity:O(n)

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False


class Solution(object):
    def __init__(self):
        self.root = TrieNode()

    def insertWord(self, word, root):
        for char in word:
            x = ord(char) - ord('a')
            if root.children[x] is None:
                root.children[x] = TrieNode()
            root = root.children[x]
        root.isEnd = True

    def searchWord(self, word, root):
        replacement = ''
        for char in word:
            x = ord(char) - ord('a')
            if root.children[x] is None:
                break
            if root.children[x] and root.isEnd==True:
                break
            replacement += char
            root = root.children[x]
        if root.isEnd:
            return replacement
        return word

    def replaceWords(self, dictionary, sentence):
        root = self.root
        for word in dictionary:
            self.insertWord(word, root)
        result = []
        for word in sentence.split():
            result.append(self.searchWord(word, root))
        return ' '.join(result)
