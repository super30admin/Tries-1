class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26


class Trie:
    def __init__(self):
        self.root = TrieNode()

    # Time Complexity : O(len(Word))
    # Space Complexity : O(len(Word))
    def insert(self, word: str) -> None:
        curr = self.root
        for char in word:
            i = ord(char) - ord('a')
            if not curr.children[i]:
                curr.children[i] = TrieNode()
            curr = curr.children[i]
        curr.isEnd = True

    def getRoot(self):
        return self.root


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        root = Trie()

        if not dictionary:
            return sentence
        for word in dictionary:
            root.insert(word)

        result = []
        sentWords = sentence.split(" ")
        for word in sentWords:
            curr = root.getRoot()
            replacementString = []
            for char in word:
                i = ord(char) - ord('a')
                if curr.children[i] == None or curr.isEnd == True:
                    break
                replacementString.append(char)
                curr = curr.children[i]
            if curr.isEnd:
                result.append("".join(replacementString))
            else:
                result.append(word)
        return " ".join(result)