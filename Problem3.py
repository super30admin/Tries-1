class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root=Node()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur=self.root
        for c in word:
            if c not in cur.children:
                cur.children[c]=Node()
                
            cur=cur.children[c]
        cur.endofword=True

        
class Node:
    def __init__(self):
        self.children=dict()
        self.endofword=False
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        TrieNode=Trie()
        
        for v in dictionary:
            TrieNode.insert(v)
        result=[]
        Listofword=sentence.split(" ")
        for word in Listofword:
            cur=TrieNode.root
            replaceword=""
            for c in word:
                if c not in cur.children or cur.endofword==True:
                    break
                replaceword+=c
                cur=cur.children[c]
            
            if cur.endofword:
                result.append(replaceword)
            else:
                result.append(word)
        return " ".join(v for v in result)
        #Time  O(NW + L), L is len of sentence, W is len of avg word in dic and N dict length
        #But it is said dic length is <100 and avg word length in dict is <1000
        #So, we can also say Time is O(L)
        #Space O(NW) , Trie space-or constant if we consider other parameters
        
        
        
        
        
