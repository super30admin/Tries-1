"""208. Implement Trie (Prefix Tree)
Time Complexity: O(N)
Space Complexity: O(m) - for insert , O(1) - for search and startswith"""

class Trie:
    class TrieNode:
        

        def __init__(self):
            """
            Initialize your data structure here.
            """
            self.children = [None for _ in range(26)]
            self.isEnd = False
        
    def __init__(self):
        self.root = self.TrieNode()
        
        
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for i in word:
            ch = ord(i) - ord('a')
            if curr.children[ch]==None:
                curr.children[ch] = self.TrieNode()
            curr = curr.children[ch]
        curr.isEnd = True
                
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        
        """
        curr =self.root
        for i in word:
            ch = ord(i)-ord('a')
            if curr.children[ch]==None:
                return False
            curr = curr.children[ch]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr =self.root
        for i in prefix:
            ch = ord(i)-ord('a')
            if curr.children[ch]==None:
                return False
            curr = curr.children[ch]
        return True
        
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)