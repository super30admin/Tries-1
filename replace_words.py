# Time Complexity: O(mn)
# Space Complexity: O(mn)
# Ran on Leetcode: Yes

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if not len(dictionary):
            return sentence
        self.root = TrieNode()
        for word in dictionary:
            self.insert(word)
        strArray = sentence.split(" ")
        res = []
        for elem in strArray:
            curr = self.root
            replace = []
            for c in elem:
                if not curr.children[ord(c) - 97] or curr.isEnd:
                    break
                replace.append(c)
                curr = curr.children[ord(c) - 97]
            if curr.isEnd:
                res.append("".join(replace))
            else:
                res.append(elem)
        return " ".join(res)
        
    def insert(self, word):
        
        curr = self.root
        for char in word:
            if not curr.children[ord(char) - 97]:
                curr.children[ord(char) - 97] = TrieNode()
            curr = curr.children[ord(char) - 97]
        curr.isEnd = True
        
    
        