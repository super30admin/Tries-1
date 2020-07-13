from queue import Queue
class TrieNode:
    def __init__(self):
        self.word=""
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
        curr.word=word
        
    def longestWord(self, words: List[str]) -> str:
        root=TrieNode()
        for s in words:
            self.insert(s)
        q=Queue()
        q.put(root)
        curr=None
        while(not(q.empty())):
            curr=q.get()
            for i in range(25,-1,-1):
                if curr.children[i]!=None and curr.children[i].word!=None:
                    q.put(curr.children[i])
        return curr.word
        
Time Complexity is O(n), n is length of words array
