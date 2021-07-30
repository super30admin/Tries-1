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
        cur=self.root
        for c in word:
            if c not in cur.children:
                cur.children[c]=Node()
                
            cur=cur.children[c]
        cur.endofword=True
       

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        cur=self.root
        for c in word:
            if c not in cur.children:
                return False
                
            cur=cur.children[c]
        return cur.endofword
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        cur=self.root
        for c in prefix:
            if c not in cur.children:
                return False
                
            cur=cur.children[c]
        return True
        
class Node:
    def __init__(self):
        self.children=dict()
        self.endofword=False
#Time Insert(O(n)), Search O(n), Startswith(O(p)), n=len(word), p=len(prefix)
# Space Insert(O(n)), Search O(1), Startswith O(1)
# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
