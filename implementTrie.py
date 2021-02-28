#TimeComplexity:O(N) for insert , O(1) for search and startsWith
#SpaceComplexity: O(N) for dictionary
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Trie:
    def __init__(self):
        self.dict={}
        self.isWord='-'
        
    def insert(self,word:str):
        cur=self.dict
        for ch in word:
            if ch in cur:
                cur=cur[ch]
            else:
                cur[ch]={}
                cur=cur[ch]
        cur[self.isWord]=self.isWord
    def search(self,word):
        cur=self.dict
        for ch in word:
            if ch not in cur:
                return False
            else:
                cur=cur[ch]
        return self.isWord in cur
    def startsWith(self,prefix):
        cur=self.dict
        for ch in prefix:
            if ch in cur:
                cur=cur[ch]
            else:return False
        return True
'''
class TrieNode:
    def __init__(self):
        self.children=[None]*26
        self.isWord=False
        
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
        cur=self.root
        for ch in word:
            if cur.children[ord(ch)-ord('a')]==None:
                cur.children[ord(ch)-ord('a')]=TrieNode()
            cur=cur.children[ord(ch)-ord('a')]
        cur.isWord=True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        cur=self.root
        for ch in word:
            if cur.children[ord(ch)-ord('a')]==None:
                return False
            cur=cur.children[ord(ch)-ord('a')]
        return cur.isWord

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        cur=self.root
        for ch in prefix:
            if cur.children[ord(ch)-ord('a')]==None:
                return False
            cur=cur.children[ord(ch)-ord('a')]
        return True
'''

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)