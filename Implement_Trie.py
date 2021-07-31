#Time: O(m)
#space: O(m)
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.children = [None]*26
        self.isend= False
        
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self
        for char in word:
            if not curr.children[ord(char)-ord("a")]:
                curr.children[ord(char)-ord("a")] = Trie()
            curr = curr.children[ord(char)-ord("a")]
        curr.isend = True
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self
        for char in word:
            if not curr.children[ord(char)-ord("a")]:
                return False
            curr = curr.children[ord(char)-ord("a")]
        return curr.isend
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self
        for char in prefix:
            if not curr.children[ord(char)-ord("a")]:
                return False
            curr = curr.children[ord(char)-ord("a")]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)