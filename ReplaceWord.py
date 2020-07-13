class TrieNode:
    def __init__(self):
        self.isEnd=None
        self.children=[None]*26
class Solution:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root=TrieNode()
    
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr=self.root
        for i in range(len(word)):
            c=word[i]
            if(curr.children[ord(c)-ord('a')]==None):
                curr.children[ord(c)-ord('a')]=TrieNode()
            curr=curr.children[ord(c)-ord('a')]
        #flag added at the end..
        curr.isEnd=True
        
    
    def replaceWords(self, dict: List[str], sentence: str) -> str:
        root=TrieNode()
        for s in dict:
            self.insert(s)
        sentenceArr=sentence.split()
        result=""
        for k in range(len(sentenceArr)):
            word=sentenceArr[k]
            if k>0:
                result+=" "
            curr=root
            replcestr=""
            for i in range(len(word)):  
                c=word[i]
                if curr.children[ord(c)-ord('a')]==None or curr.isEnd:
                    break
                replcestr+=c
                curr=curr.children[ord(c)-ord('a')]
            if(curr.isEnd):
                result+=replcestr
            else:
                result+=word
        return result
        
 Time Complexity: dictionary had n words, average length is L, sentence has m words, average length is L, nL and mL, so O(m+n)
 
