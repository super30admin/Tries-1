# Time Complexity :  Insert & startsWith: O(K) Search: O(1)
# Space Complexity: N * K where K: Length of the longest word
# Passed Leetcode 

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.trie = {}
        self.words = set()
        
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        temp = self.trie
        for i, w in enumerate(word):
            
            if w not in temp:
                temp[w] = {}
            temp = temp[w]
        self.words.add(word)
            
            

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        if word in self.words:
            return True
        return False
    
    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        temp = self.trie
        for i, w in enumerate(prefix):
            
            if w not in temp:
                return False
            temp = temp[w]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)