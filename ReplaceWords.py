class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26


class Solution:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for c in word:
            index = ord(c) - ord('a')
            if curr.children[index] is None:
                curr.children[index] = TrieNode()
            curr = curr.children[index]
        curr.isEnd = True

    def replaceWords(self, dictionary, sentence):
        for word in dictionary:
            self.insert(word)
        
        strArr = sentence.split()
        result = []
        for word in strArr:
            replacement = []
            curr = self.root
            for ch in word:
                index = ord(ch) - ord('a')
                if curr.isEnd or curr.children[index] == None:
                    break
                else:
                    replacement.append(ch)
                curr = curr.children[index]
            result.append(" ")
            if not curr.isEnd:
                result.append(word)
            else:
                result.append(''.join(replacement))
        
        return ''.join(result).strip()
        
        



        
