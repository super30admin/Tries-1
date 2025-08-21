class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None for i in range(26)]
            self.isEnd = False

    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            letter = word[i]
            if curr.children[ord(letter) - ord('a')] == None:
                curr.children[ord(letter) - ord('a')] = self.TrieNode()
            curr = curr.children[ord(letter) - ord('a')]
        curr.isEnd = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:

        if sentence == None or len(sentence) == 0:
            return sentence

        self.root = self.TrieNode()

        for word in dictionary:
            self.insert(word)

        result = []
        for word in sentence.split(" "):
            replacement = []
            curr = self.root
            for i in range(len(word)):
                c = word[i]
                if curr.children[ord(c) - ord('a')] == None or curr.isEnd == True:
                    break
                replacement.append(c)
                curr = curr.children[ord(c) - ord('a')]
            if curr.isEnd == True:
                result.append("".join(replacement))
            else:
                result.append(word)

        return " ".join(result)