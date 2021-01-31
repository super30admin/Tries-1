class Solution:
    #Approach: Tries
    #Time Complexity: O(m*n + k*l)
    #Space Complexity: O(k*l)
    #where, m is the num of words in the sentence, and n is the average length of a word in it
    #and, k is the num of words in the dictionary, and l is the average length of a word in it
        
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word):
        curr = self.root
        for char in word:
            idx = ord(char) - ord('a')
            if not curr.children[idx]:
                curr.children[idx] = TrieNode()
            curr = curr.children[idx]
        curr.isEnd = True
        return
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
            self.insert(word)
        
        result = []
        for word in sentence.split(' '):
            replacement = ''
            curr = self.root
            for char in word:
                idx = ord(char) - ord('a')
                if not curr.children[idx] or curr.isEnd:
                    break
                replacement += char
                curr = curr.children[idx]
            
            if curr.isEnd:
                result.append(replacement)
            else:
                result.append(word)
        
        return ' '.join(result)

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for i in range(26)]