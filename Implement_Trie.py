# TC: O(N X L)
# SC: O(N X L)


class Trie:

    class TrieNode:
        def __init__(self):
            self.children = [None] * 26
            self.isEnd = False

    def __init__(self):
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        curr=self.root
        for i in range(0,len(word)):
            if curr.children[ord(word[i])-ord("a")]==None:
                curr.children[ord(word[i])-ord("a")]=self.TrieNode()
            curr=curr.children[ord(word[i])-ord("a")]

        # print(chr(ord(word[i])))
        curr.isEnd=True
        
    def search(self, word: str) -> bool:
        curr=self.root
        for i in range(0,len(word)):
            if curr.children[ord(word[i])-ord("a")]==None:
                return False
            curr=curr.children[ord(word[i])-ord("a")]
        return curr.isEnd
         

    def startsWith(self, prefix: str) -> bool:
        curr=self.root
        for i in range(0,len(prefix)):
            if curr.children[ord(prefix[i])-ord("a")]==None:
                return False

            curr=curr.children[ord(prefix[i])-ord("a")]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)