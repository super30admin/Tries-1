class TrieNode:
    def __init__(self):
        self.isEnd=False
        self.children=[None]*26
        
class Trie:

    def __init__(self):
        self.root=TrieNode()      
        

    def insert(self, word: str) -> None:
        """Time complexity-O(k) where k is the length of the word
        Space complexity-O(k) where k is the max length of the word"""
        """
        Inserts a word into the trie.
        """
        curr=self.root
        for i in range(len(word)):
            ch=word[i]
            if curr.children[ord(ch)-ord('a')]==None:
                curr.children[ord(ch)-ord('a')]=TrieNode()
            curr=curr.children[ord(ch)-ord('a')]
        curr.isEnd=True
            
            
        

    def search(self, word: str) -> bool:
         """Time complexity-O(k) where k is the length of the word
         Space complexity-O(k)"""
        """
        Returns if the word is in the trie.
        """
        curr=self.root
        for i in range(len(word)):
            ch=word[i]
            if curr.children[ord(ch)-ord('a')]==None:
                return False
            curr=curr.children[ord(ch)-ord('a')]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
         """Time complexity-O(n) where n is the length of the prefix
         Space complexity-O(n)"""
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr=self.root
        for i in range(len(prefix)):
            ch=prefix[i]
            if curr.children[ord(ch)-ord('a')]==None:
                return False
            curr=curr.children[ord(ch)-ord('a')]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)