class Trie:
    class TrieNode:
        def __init__(self):
            self.lst=[None]*26
            self.flag=False

    def __init__(self):
        self.root=self.TrieNode()
        
#Time complexity: O(L)
#Space complexity: In the worst case we are creating TrieNode objects for every letter in the word -> O(26*L)
    def insert(self, word: str) -> None:
        curr=self.root
        for i in range(len(word)):
            char=word[i]
            if curr.lst[ord(char)-ord("a")] is None:
                curr.lst[ord(char)-ord("a")]=self.TrieNode()
            curr=curr.lst[ord(char)-ord("a")]
        curr.flag=True
        
#Time complexity: O(L)
#Space complexity: O(1)
    def search(self, word: str) -> bool:
        curr=self.root
        for i in range(len(word)):
            char=word[i]
            if curr.lst[ord(char)-ord("a")] is None:
                return False
            curr=curr.lst[ord(char)-ord("a")]
        return curr.flag

#Time complexity: O(Length of prefix)
#Space complexity: O(1)
    def startsWith(self, prefix: str) -> bool:
        curr=self.root
        for i in range(len(prefix)):
            char=prefix[i]
            if curr.lst[ord(char)-ord("a")] is None:
                return False
            curr=curr.lst[ord(char)-ord("a")]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)