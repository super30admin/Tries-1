"""
Insert:
TC 0(m)
Space complexity O(m)

search
TC O(m)
sc O(1)

startsWith
TC O(M)
sc O(1)


"""


class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root=TrieNode()
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr=self.root
        for i in range(len(word)):
            c=word[i]
            if c not in curr.children:
                curr.children[c]=TrieNode()
            curr=curr.children[c]
        curr.isEnd=True
            
            

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr=self.root
        for i in range(len(word)):
            c=word[i]
            if c not in curr.children:
                return False
            curr=curr.children[c]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr=self.root
        for i in range(len(prefix)):
            c=prefix[i]
            if c not in curr.children:
                return False
            curr=curr.children[c]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)