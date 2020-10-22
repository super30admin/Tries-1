class Node:
    
    def __init__(self):
        self.sub = collections.defaultdict(Node)
        #here should have a isend attribute, we store the word instead.
        self.word = None
        
class Trie:
    
    def __init__(self):
        self.root = Node()
    
    def insert(self, word):
        cur = self.root
        for i in word:
            cur = cur.sub[i]
        cur.word = word
        
    def find(self, word):
        cur = self.root
        for i in word:
            #this means this sentence word has no 'root'
            if i not in cur.sub: return word
            cur = cur.sub[i]
            if cur.word is not None: return cur.word 
        #cannot find a matched root for current word
        return word  
        
class Solution:
    def replaceWords(self, dict: List[str], sentence: str) -> str:
        roots = Trie()
        string = ""
        for word in dict:
            roots.insert(word)
            
        for word in sentence.split():
            string += roots.find(word)
            string += " "
        return string[:-1]
        # return ' '.join(roots.find(word) for word in sentence.split())
