class TrieNode:
    def __init__(self):
        self.children=[None for i in range(26)]
        self.isend=False
        
class Trie:
     """
    TC: O(l)
    SC:O(1)
    """
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root=TrieNode()
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur=self.root
        for i in range(len(word)):
            ch=word[i]
            if not cur.children[ord[ch]-ord['a']]:
                cur.children[ord[ch]-ord['a']] = TrieNode()
            cur=cur.children[ord[ch]-ord['a']]
        cur.isend=True
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        cur=self.root
        for i in range(len(word)):
            ch=word[i]
            if not cur.children[ord[ch]-ord['a']]:
                return False
            cur=cur.children[ord(ch)-ord('a')]
        return cur.isend
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        cur=self.root
        for i in range(len(prefix)):
            ch=prefix[i]
            if not cur.children[ord(ch)-ord('a')]:
                return False
            cur=cur.children[ord(ch)-ord('a')]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)