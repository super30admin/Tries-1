#Time Complexity : O(n+m)
#Space Complexity : O(n+m)
class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False
class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        curr = self.root
        for c in word:
            i = ord(c) - ord("a")
            if curr.children[i] == None:
                curr.children[i] = TrieNode()
            curr = curr.children[i]
        curr.isEnd = True
    
    def find_root(self, word):
        curr = self.root
        for i, c in enumerate(word):
            index = ord(c) - ord("a")
            if curr.children[index] is None:
                return word
            curr = curr.children[index]
            if curr.isEnd:
                return word[:i+1]
            
        return word
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        node = Trie()
        for word in dictionary:
            node.insert(word)
        words = sentence.split()
        for i, word in enumerate(words):
            words[i] = node.find_root(word)
        
        return " ".join(words)