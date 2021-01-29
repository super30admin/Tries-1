# Time Complexity : O(N) for all
# Space Complexity : O(1) for startWith and Search. O(N) for insert
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nope


# Your code here along with comments explaining your approach

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for i in range(26)]
        
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.head = TrieNode()
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.head 
        
        for i in range(len(word)):
            c = word[i]
            if not curr.children[ord(c) - ord('a')]:
                curr.children[ord(c)- ord('a')] = TrieNode()
            curr = curr.children[ord(c)-ord('a')]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.head 
        for i in range(len(word)):
            c = word[i]
            if not curr.children[ord(c) - ord('a')]:
                return False
            curr = curr.children[ord(c) - ord('a')]
        return curr.isEnd 

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.head 
        for i in range(len(prefix)):
            c = prefix[i]
            if not curr.children[ord(c) - ord('a')]:
                return False
            curr = curr.children[ord(c) - ord('a')]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)