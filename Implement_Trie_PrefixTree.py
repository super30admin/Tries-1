class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None]* 26

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
        for w in word:
            if not curr.children[ord(w)-ord('a')]:
                curr.children[ord(w)-ord('a')] = TrieNode()
            curr = curr.children[ord(w)-ord('a')]        
        curr.isEnd=True

        
    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for w in word:
            if not curr.children[ord(w)-ord('a')]:
                return False
            curr = curr.children[ord(w)-ord('a')]
        
        return curr.isEnd

    def print_dct(self):
        curr = self.root
        for i in range(26):
            if curr.children[i]:
                print(curr.children[i])
                curr = curr.children[i]

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        
        curr = self.root
        
        for w in prefix:
            if not curr.children[ord(w)-ord('a')]:
                return False
            curr = curr.children[ord(w)-ord('a')]
        
        return True


#Your Trie object will be instantiated and called as such:
word = "apple"
prefix = "app"
obj = Trie()
obj.insert(word)
param_2 = obj.search(word)
param_3 = obj.startsWith(prefix)
obj.print_dct()


