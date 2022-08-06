class TrieNode:
    def __init__(self):
        self.children = [None]*26           # Else we get list out of index error
        self.isEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        curr = self.root
        for char in word:
            # To find the index using ASCII values
            c = ord(char) - ord('a')
            # If there is no Trie present at the respected index of the char, create one
            if curr.children[c] == None:
                curr.children[c] = TrieNode()
                curr.children[c].val = char         # Add char as value
            
            # Move the curr pointer/trie to the inserted char
            curr = curr.children[c]
        
        # Once the complete word is inserted, make it True, for the end of the word
        curr.isEnd = True
        

    def search(self, word: str) -> bool:
        curr = self.root
        for char in word:
            c = ord(char) - ord('a')
            # If there is no Trie present at the respected index of the char, return False
            if curr.children[c] == None:
                return False
            
            # Move the curr pointer/trie to the inserted char
            curr = curr.children[c]
            
        # To check if thesearched word is present as a word or a part of another word
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for char in prefix:
            c = ord(char) - ord('a')
            # If there is no Trie present at the respected index of the char, => no children, return False
            if curr.children[c] == None:
                return False
            
            # Move the curr pointer/trie to the inserted char
            curr = curr.children[c]
            
        return True
        
      
    # Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)