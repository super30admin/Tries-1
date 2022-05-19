class Trie:
    def __init__(self):
        self.children = [None]*26
        self.word = ''

class Solution: 
    def createTrie(self, words):
        root = Trie()
        charA = ord('a')
        
        for word in words:
            curr = root
            for i in range(len(word)):
                if curr.children[ord(word[i])-charA] == None:
                    curr.children[ord(word[i])-charA] = Trie()
                curr = curr.children[ord(word[i])-charA]
                
            curr.word = word  
        return root
        
    def longestWord(self, words: List[str]) -> str:
        if not words:
            return ''
        
        root = self.createTrie(words)
        curr = root
        queue = []
        queue += [curr]
        
        while queue:
            curr = queue.pop(0)
            for i in range(25,-1,-1):
                if curr.children[i] and curr.children[i].word:
                    queue += [curr.children[i]]
        
        return curr.word