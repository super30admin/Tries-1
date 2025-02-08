class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None for _ in range(26)]
            self.isEnd = False
        
    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c) - ord('a')] == None:
                curr.children[ord(c) - ord('a')] = self.TrieNode()
            curr = curr.children[ord(c) - ord('a')]
        curr.isEnd = True
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.root = self.TrieNode()
        
        for word in dictionary:
            self.insert(word)
        splitArray = sentence.split(' ')
        result = []
        for each_word in splitArray:
            replacement = []
            curr = self.root
            for c in each_word:
                if curr.children[ord(c) - ord('a')] == None or curr.isEnd is True:
                    break
                replacement.append(c)
                curr = curr.children[ord(c) - ord('a')]
            if curr.isEnd is True:
                result.append("".join(replacement))
            else:
                result.append(each_word)
        return " ".join(result)
