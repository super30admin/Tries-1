class TrieNode:
    def __init__(self):
        self.isEnd=None
        self.children=[None]*26
class Trie:
        
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
                       
    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr=self.root
        for i in range(len(word)):
            c=word[i]
            if(curr.children[ord(c)-ord('a')]==None):
                return False
            curr=curr.children[ord(c)-ord('a')]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr=self.root
        for i in range(len(prefix)):
            c=prefix[i]
            if(curr.children[ord(c)-ord('a')]==None):
                return False
            curr=curr.children[ord(c)-ord('a')]
        return True

Time Complexity is O(Length of the word)
