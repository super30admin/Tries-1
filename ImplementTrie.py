# TC: For insert: O(N) where N = length of the word to be inserted. 
# SC: O(M) since we are storing the word in the hashmap. In worst case, when there is no prefix to a word, we will have to store all the letters in the word.
# TC: For search: O(N) where N is length of the word to be searched. 
# SC: O(1) 
# TC: For prefix check: O(M) where M is the length of prefix string
# SC: O(1) since we are not using any extra space.

class TrieNode:
    
    def __init__(self):
        self.children = {}
        self.isEnd = False

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
                
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for letter in word: 
            if letter not in curr.children: 
                curr.children[letter] = TrieNode()
            curr = curr.children[letter]
        
        curr.isEnd = True        
        
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for letter in word:
            if letter not in curr.children: 
                return False
            curr = curr.children[letter]
        
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for letter in prefix: 
            if letter not in curr.children: 
                return False
            curr = curr.children[letter]
        return True
        
