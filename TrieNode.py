# Time Complexity : O(n) for all methods, where n is the length of word/prefix
# Space Complexity : O(nl), where n is the number of words in the trie and l is the average length of the words
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class TrieNode: 
      
    # Trie node class 
    def __init__(self): 
        self.children = [None]*26
  
        # isEndOfWord is True if node represent the end of the word 
        self.isEndOfWord = False
class Trie:
    TrieNode
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
        for ch in word:
            if not curr.children[ord(ch)-ord('a')]:
                curr.children[ord(ch)-ord('a')] = TrieNode()
            curr = curr.children[ord(ch)-ord('a')]
        curr.isEndOfWord = True
                
            
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for ch in word:
            if not  curr.children[ord(ch)-ord('a')]:
                return False
            curr = curr.children[ord(ch)-ord('a')]
        #curr.isEndOfWord = False
        if curr:
            return curr.isEndOfWord == True
            
            

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for ch in prefix:
            if  not  curr.children[ord(ch)-ord('a')]:
                return False
            curr = curr.children[ord(ch)-ord('a')]
        if curr:
            return True
        return False

