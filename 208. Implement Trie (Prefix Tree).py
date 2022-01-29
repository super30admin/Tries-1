# time complexity: O(n)
# space complexity: O(n)

class Trie:
    
    class TrieNode:
        
        def __init__(self):
            self.children=[None]*26
            self.isEnd=False
            
    root=TrieNode()
    
    def __init__(self):
        self.root=self.TrieNode()

    def insert(self, word: str) -> None:
        curr=self.root
        for i in range(len(word)):
            let=word[i]
            if curr.children[ord(let)-ord('a')]==None:
                curr.children[ord(let)-ord('a')]=self.TrieNode()
                
            curr=curr.children[ord(let)-ord('a')]
            
        curr.isEnd=True
        
    def search(self, word: str) -> bool:
        curr=self.root
        for i in range(len(word)):
            let=word[i]
            if curr.children[ord(let)-ord('a')]==None:
                return False
            curr=curr.children[ord(let)-ord('a')]
            
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr=self.root
        for i in range(len(prefix)):
            let=prefix[i]
            if curr.children[ord(let)-ord('a')]==None:
                return False
            
            curr=curr.children[ord(let)-ord('a')]
            
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)