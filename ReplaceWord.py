# Time Complexity : O(D * Avg(W) + D * Avg(W) + O(S))
# D = len(Dictionary)
# Avg(W) = Average len of Word
# S = len of String
# Space Complexity : 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TrieNode:
    def __init__(self, char):
        self.char = char
        self.children = [None] * 26
        self.isWord = False
        
class Solution:
    
    def __init__(self):
        self.trie = TrieNode("0")
        
    def insert(self, word):
        t = self.trie
        for char in word:
            childIdx = ord(char) - ord('a')
            if not t.children[childIdx]:
                newNode = TrieNode(char)
                t.children[childIdx] = newNode
            
            t = t.children[childIdx]
        
        t.isWord = True

    def findRoot(self, word):
        t = self.trie
        root_word = []
        for char in word:
            root_word.append(t.char)
            childIdx = ord(char) - ord('a')
            if not t.children[childIdx] or t.isWord:
                break
            t = t.children[childIdx]   
        if t.isWord:
            return "".join(root_word[1:])
        return ""
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        for word in dictionary: # O(D) D = len(Dictionary)
            self.insert(word) # O(W) O(W) W = len(word)
        
        sentWords = sentence.split(" ")
        result = []

        for word in sentWords: # O(D) D = len(Dictionary)
            curr_root = self.findRoot(word) # O(W) W = len(word) (Worst Case)
            if not curr_root:
                result.append(word)
            
            else:
                result.append("".join(curr_root))
        
        return " ".join(result) # O(S) S = len(sentence)

        # Total = O(D * Avg(W) + D * Avg(W) + O(S))