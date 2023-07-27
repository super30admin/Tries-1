class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26


class Solution:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        curr = self.root
        for ch in word:
            index = ord(ch) - ord('a')
            if curr.children[index] == None:
                curr.children[index] = TrieNode()
            curr = curr.children[index]
        curr.isEnd = True

    def longestWord(self, words: List[str]) -> str:
        for word in words:
            self.insert(word)
        
        result = ''
        for word in words:
            temp = []
            curr = self.root
            valid = True
            for ch in word:
                index = ord(ch) - ord('a')
                if curr.children[index] == None or not curr.children[index].isEnd:
                    valid = False
                    break
                temp.append(ch)
                curr = curr.children[index]

            if valid:
                t = ''.join(temp)
                if len(temp) > len(result) or (len(temp) == len(result) and t < result):
                    result = t
        return result









