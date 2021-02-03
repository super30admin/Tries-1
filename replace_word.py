# Time Complexity : O(n) where n is the length of the word
# Space Complexity : O(N) where N is the size of the input roots
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I iterate through trie for each word and return the prefix where I find the first root

class TrieNode:
    def __init__(self):
        self.children = [None for x in range(26)]
        self.is_end = None
        
class Trie:
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word):
        current = self.root
        for l in word:
            index = ord(l) - ord("a")
            if not current.children[index]:
                current.children[index] = TrieNode()
            current = current.children[index]
        current.is_end = word

    def get_root(self, word):
        current = self.root
        for l in word:
            index = ord(l) - ord("a")
            current = current.children[index]
            if not current:
                return word
            if current.is_end:
                return current.is_end
            
        return word
        
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        t = Trie()
        
        for word in dictionary:
            t.insert(word)
            
        sentence_arr = sentence.split(" ")
        result_arr = []
        
        for word in sentence_arr:
            result_arr.append(t.get_root(word))
            
        return " ".join(result_arr)
        
        
        