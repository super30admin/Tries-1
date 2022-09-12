'''
Time Complexity: O(n * k) where n is number of words and k is max length of a word
Space Complexity:O(n * 26 ^ k)
'''


class TrieNode():
    def __init__(self):
        self.isEnd = False
        self.children = [None for i in range(26)]


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.root = TrieNode()
        for word in dictionary:
            self.insert(word)
        strArr = sentence.split(" ")
        result = []
        for i in range(len(strArr)):
            currWord = strArr[i]
            curr = self.root
            replace = ""
            if i != 0:
                result.append(" ")
            for j in range(len(currWord)):
                char = currWord[j]
                if curr.children[ord(char) - ord('a')] == None or curr.isEnd:
                    break
                replace += (char)
                curr = curr.children[ord(char) - ord('a')]
            if curr.isEnd:
                result.append(replace)
            else:
                result.append(strArr[i])
        return "".join(result)

    def insert(self, word):
        curr = self.root
        for char in word:
            if curr.children[ord(char) - ord('a')] == None:
                curr.children[ord(char) - ord('a')] = TrieNode()
            curr = curr.children[ord(char) - ord('a')]
        curr.isEnd = True
