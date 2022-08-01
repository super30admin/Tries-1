class TrieNode:
    def __init__(self):
        self.children=[None for _ in range(26)]
        self.is_end=False
        
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        words=sentence.split(' ')
        root=TrieNode()
        result=[]
        
        def insert(word):
            current=root
            for i in word:
                if current.children[ord(i)-ord('a')] is None:
                    current.children[ord(i)-ord('a')]=TrieNode()
                    
                current=current.children[ord(i)-ord('a')]
                
            current.is_end=True
            
        def replace(word):
            current=root
            string=[]
            for i in word:
                if current.children[ord(i)-ord('a')] is None or current.is_end:
                    break
                
                string.append(i)
                current=current.children[ord(i)-ord('a')]
            
            l=''.join(string)
            if len(string)>0 and l in dictionary:
                result.append(''.join(string))
            else:
                result.append(word)
        
        for i in dictionary:
            insert(i)
            
        for i in words:
            replace(i)
            
        return ' '.join(result)
        
        