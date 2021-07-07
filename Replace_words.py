# Runs on Leetcode
    # Runtime complexity 
          - O(W*L) where W is number of words, L is avg length of words
    # Memory complexity
          - actual space is  O((m*n)+1) where m = number of words in dict - 1, n = avg length of words
          - asymptotically - O(n) where n is average length of words in dict

class Solution:
    class TrieNode:
        def __init__(self, char):
            self.char = char
            self.children = [None]*26
            self.string = None
    
    def __init__(self):
        self.root = self.TrieNode(None)
        
    def insert(self, word):
        node = self.root
        for i in word:
            if not node.children[ord(i) - ord('a')]:
                node.children[ord(i) - ord('a')] = self.TrieNode(i)
            node = node.children[ord(i) - ord('a')]
        node.string = word
        
    def getroot(self,word):
        node = self.root
        char = 0
        while char < len(word):
            if not node.string:
                if node.children[ord(word[char]) - ord('a')]:
                    node = node.children[ord(word[char]) - ord('a')]
                else:
                    return
            else:
                return node.string
            char += 1
                
    def replaceWords(self, dict: List[str], sentence: str) -> str:
        if not dict:
            return sentence
        for i in dict:
            self.insert(i)
        sentence = sentence.split(' ')  
        for i in range(len(sentence)):
            a = self.getroot(sentence[i])
            if a:
                sentence[i] = a
            else:
                continue
        return " ".join(sentence)
