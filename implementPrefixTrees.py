"""
TC: O(n*k) for Trie insertion, n- number of words in dicionary , k avg length of each word, 
SP: O(n*k)o store all the words

"""


class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False
class Trie:

    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            if curr.children[ord(c)-ord('a')] == None:
                curr.children[ord(c)-ord('a')] = TrieNode()
            curr = curr.children[ord(c)-ord('a')]
        curr.isEnd = True
        

    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            if curr.children[ord(c)-ord('a')] == None:
                return False
            curr = curr.children[ord(c)-ord('a')]
        return curr.isEnd == True
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            if curr.children[ord(c)-ord('a')] == None:
                return False
            curr = curr.children[ord(c)-ord('a')]
        return True
        
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)