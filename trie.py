
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # initialize a prefix tree.
        self.trie = dict()
        
    # Time complexity - O(l) where l is the length of the word
    # Worst case Space complexity - O(l)      
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        # iterate through every word
        prev = None
        curr = self.trie
        for ch in word:
            if ch not in curr:
                curr[ch] = dict()
            curr = curr[ch]
        curr["end"] = "end"
       
    # Time complexity - O(l) where l is the length of the word
    # Worst case Space complexity - O(1)  
    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.trie
        for ch in word:
            if ch not in curr:  # check if the character is not in the prefix tree.
                return False
            curr = curr[ch]
        return "end" in curr

    # Time complexity - O(l) where l is the length of the word
    # Worst case Space complexity - O(1) 
    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.trie
        for ch in prefix:
            if ch not in curr:
                return False
            curr = curr[ch]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
