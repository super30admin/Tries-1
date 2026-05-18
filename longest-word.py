# time: O(N*L) - N is number of words in array and L is max length
# space: O(N*L) - storing characters of words in TrieNodes 

class Solution:
    class TrieNode:
        def __init__(self):
            self.children={}
            self.endOfWord=False
    def __init__(self):
        self.root = self.TrieNode()
    
    def insert(self,word):
        curr = self.root
        for c in word:
            if c not in curr.children:
                curr.children[c]=self.TrieNode()
            curr = curr.children[c]
        curr.endOfWord = True
    def isValid(self,word):
        # check if every prefix exists in the trie
        curr = self.root
        for c in word:
            if c not in curr.children:
                return False
            curr = curr.children[c]
            if not curr.endOfWord:
                return False
        return True

    def longestWord(self, words: List[str]) -> str:
        for word in words:
            self.insert(word)
        longestValidWord=''
        for word in words:
            if self.isValid(word):
                if len(word) > len(longestValidWord):
                    longestValidWord=word
                elif len(word) == len(longestValidWord):
                    # lexicographically smaller
                    if word < longestValidWord:
                        longestValidWord=word
        
        return longestValidWord