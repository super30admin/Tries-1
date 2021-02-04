#time: O(m), m is the avg length of the words
#space: O(1)

class Node:
    def __init__(self):
        self.isEnd=False
        self.children=[None for i in range(26)]

class Trie:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root=Node()
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr=self.root
        for c in word:
            s=ord(c)
            a=ord('a')
            if(curr.children[s-a]==None):
                curr.children[s-a]=Node()
            curr=curr.children[s-a]
        curr.isEnd=True
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr=self.root
        for c in word:
            s=ord(c)
            a=ord('a')
            if(curr.children[s-a]==None):
                return False
            curr=curr.children[s-a]
        if(curr.isEnd==True):
            return True
        else:
            return False
        
        
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr=self.root
        for c in prefix:
            s=ord(c)
            a=ord('a')
            if(curr.children[s-a]==None):
                return False
            curr=curr.children[s-a]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)