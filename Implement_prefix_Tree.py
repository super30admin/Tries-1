# Time Complexity:- O(w) w=length of word
# Space Complexity:- O(1)
# Approach- Use and array of length 27 to store the aplhabets from a-z and add an additional bit to indicate end of word.
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root=[-1]*27
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr=self.root
        for i in word:
            if curr[ord(i)-ord('a')]==-1:
                curr[ord(i)-ord('a')]=[-1]*27
                curr=curr[ord(i)-ord('a')]
            else:
                curr=curr[ord(i)-ord('a')]
        curr[26]=1
                
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr=self.root
        for i in word:
            if curr[ord(i)-ord('a')]==-1:
                return False
            curr=curr[ord(i)-ord('a')]
        if curr[26]==1:
            return True
        else:
            return False
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr=self.root
        for i in prefix:
            if curr[ord(i)-ord('a')]==-1:
                return False
            curr=curr[ord(i)-ord('a')]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)