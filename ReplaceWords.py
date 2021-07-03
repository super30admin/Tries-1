class TrieNode:
    """Tries
    Time Complexity-O(L+(n*k)) where L is the length of the sentence and n is the number of words that need to be inserted and k is the max length of word that need to be inserted.
    Space Complexity-O(nk+L) as we are using list to split sentence and n words need to be inserted into Trie with max length K"""
    def __init__(self):
        self.isEnd=False
        self.children=[None]*26
class Solution:
    def __init__(self):
        self.root=TrieNode()
        self.result=[]
    
    def insert(self, word):
        curr=self.root
        for i in range(len(word)):
            ch=word[i]
            if curr.children[ord(ch)-ord('a')]==None:
                curr.children[ord(ch)-ord('a')]=TrieNode()
            curr=curr.children[ord(ch)-ord('a')]
        curr.isEnd=True
            
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for dic in dictionary:
            self.insert(dic)
        li=sentence.split()
        for k in range(len(li)):
            if k>0:
                self.result.append(" ")
            word=li[k]
            curr=self.root
            temp=[]
            for i in range(len(word)):
                ch=word[i]
                if curr.children[ord(ch)-ord('a')]==None or curr.isEnd:
                    break
                curr=curr.children[ord(ch)-ord('a')]
                temp.append(ch)
            if curr.isEnd:
                newWord="".join(temp)
                self.result.append(newWord)
            else:
                self.result.append(word)
            
        return "".join(self.result)
                
            
            
        
        
        