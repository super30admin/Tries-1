#TC-o(n)
class TrieNode:
    def __init__(self):
        self.children=[None]*26
        self.isEnd=False

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
            ch=ord(c)-ord('a')
            if curr.children[ch]==None:
                curr.children[ch]=TrieNode()
            curr=curr.children[ch]
        curr.isEnd=True
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr=self.root
        for i in range(len(word)):
            c=word[i]
            ch=ord(c)-ord('a')
            if not curr.children[ch]:
                return False
            curr=curr.children[ch]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr=self.root
        for i in range(len(prefix)):
            c=prefix[i]
            ch=ord(c)-ord('a')
            if not curr.children[ch]:
                return False
            curr=curr.children[ch]
        return True
        
