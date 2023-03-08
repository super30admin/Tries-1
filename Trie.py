#All TC passed on leetcode


class TrieNode:
    #Here each TrieNode has list of 26 TrieNodes as children. If the child is None then no letter present there. 
    #If its not None the a new TrieNode exists which has its own 26 TrieNode children.
    def __init__(self):
        self.isEnd = False
        self.children = [None]*26




class Trie:

    def __init__(self):
        self.root = TrieNode()

    #Time complexity - O(n) where n is length of word
    #Space complexity - O(1) - as no extra space used here
    def insert(self, word: str) -> None:
        cur = self.root
        for i in range(len(word)):
            if not cur.children[ord(word[i])-ord('a')]:
                cur.children[ord(word[i])-ord('a')] = TrieNode()
            cur =  cur.children[ord(word[i])-ord('a')]

        cur.isEnd = True

    #Time complexity - O(n) where n is length of word
    #Space complexity - O(1)
    def search(self, word: str) -> bool:
        cur = self.root
        for i in range(len(word)):
            if not cur.children[ord(word[i])-ord('a')]:
                return False
            cur = cur.children[ord(word[i])-ord('a')]
        return cur.isEnd
        
    #Time complexity - O(n) where n is length of prefix
    #Space complexity - O(1)
    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        for i in range(len(prefix)):
            if not cur.children[ord(prefix[i])-ord('a')]:
                return False
            cur = cur.children[ord(prefix[i])-ord('a')]
        return True

        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)