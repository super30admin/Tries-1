class Trie:
    '''
    Time Complexity: O(m)
    Space Complexity: O(1)
    
    '''
    class Node:
        def __init__(self):
            self.alphabet = [None for i in range(0,26)]
            self.endWord = False

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = Trie.Node()
        
        
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        temp = self.root
        for w in word:
            if(temp.alphabet[ord(w)-ord('a')]!=None):
                temp = temp.alphabet[ord(w)-ord('a')]
            else:
                temp.alphabet[ord(w)-ord('a')] = Trie.Node()
                temp = temp.alphabet[ord(w)-ord('a')]
        
        temp.endWord = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        temp = self.root
        for w in word:
            if(temp.alphabet[ord(w)-ord('a')]!=None):
                temp = temp.alphabet[ord(w)-ord('a')]
            else:
                return False
        
        return temp.endWord        
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        temp = self.root
        for w in prefix:
            if(temp.alphabet[ord(w)-ord('a')]!=None):
                temp = temp.alphabet[ord(w)-ord('a')]
            else:
                return False
        
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
