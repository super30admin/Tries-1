class TrieNode:
    def __init__(self):
        self.child = {}
        self.word = ''
        self.isEnd = False
class Solution:
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self,word):
        curr = self.root
        for i in word:
            if i not in curr.child:
                curr.child[i] = TrieNode()
            curr = curr.child[i]
        curr.isEnd = True    
        curr.word= word
        
    def longestWord(self, words: List[str]) -> str:
        if(len(words) == 0):
            return ''
        for i in words:
            self.insert(i)
        
        q = []
        curr = self.root 
        q.append(self.root)
        while(q):
            curr = q.pop(0)
            for i in reversed(string.ascii_lowercase): 
                if i in curr.child and curr.child[i].word != '':
                    q.append(curr.child[i])
                    
        
        if(curr.word is None):
            return ''
        return curr.word