# // Time Complexity : O(nl) where n is the length of the dictionary and l is the average length of a word.
# // Space Complexity : O(nl) where n is the length of the dictionary and l is the average length of a word.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

class Node:

    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26
        
class Trie:

    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in word:
            if curr.children[ord(i) - ord('a')] == None:
                curr.children[ord(i) - ord('a')] = Node()
            curr = curr.children[ord(i) - ord('a')]
        curr.isEnd = True
        

    def search(self, word: str) -> bool:
        curr = self.root
        for i in word:
            if curr.children[ord(i) - ord('a')] == None:
                return False
            curr = curr.children[ord(i) - ord('a')]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in prefix:
            if curr.children[ord(i) - ord('a')] == None:
                return False
            curr = curr.children[ord(i) - ord('a')]
        return True



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
