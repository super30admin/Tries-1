class TrieNode:
    def __init__(self):
        self.childNodes = [None]*26    # every node will have 26 children
        self.isWordEnd = False
class Trie:
    

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:   #tc  is o(lengthofword)
        """
        Inserts a word into the trie.
        """
        curr = self.root                                                 
        for c in word:
            if (curr.childNodes[ord(c)-ord('a')]==None):
                curr.childNodes[ord(c)-ord('a')]= TrieNode()
            curr = curr.childNodes[ord(c)-ord('a')]
        
        curr.isWordEnd =True
        

    def search(self, word: str) -> bool:  #tc  is o(lengthofword)
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for c in word:
            curr = curr.childNodes[ord(c)-ord('a')]
            if curr == None:
                return False
        if curr.isWordEnd:
            return True
        return False

    def startsWith(self, prefix: str) -> bool:    #tc  is o(lengthofword)
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for c in prefix:
            curr = curr.childNodes[ord(c)-ord('a')]
            if curr == None:
                return False
        return True
        
        
        #sc is o(26nm), n = no. of words, m = average length of word
        
        
