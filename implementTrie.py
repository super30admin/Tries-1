"""
Approach --
Create a node class with isEnd = False and an arr of children of size 26 since we are only considering lower case characters
a. Insert
- assign root to curr
- check if the char is present in word. If not, create a trie node
- continue through the length of the string
- mark end of string as True
b. Search
- assign root to curr
- check if the char is present in word. If no, return false
- Else, continue till the end of the string
- Return true if isEnd == True
c. startsWith
- assign root to curr
- check if the char is present in word. If no, return false
- Else continue till the end of the string. Return True

TC - O(n) where n is the length of the string
SC - O(1)
"""
class Node:
    def __init__(self):
        self.isEnd = False
        self.children = [None]*26

class Trie:

    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        curr = self.root
        for char in word:
            if curr.children[ord(char) - ord('a')] is None:
                curr.children[ord(char) - ord('a')] = Node()
            curr = curr.children[ord(char) - ord('a')]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        curr = self.root
        for char in word:
            if curr.children[ord(char) - ord('a')] is None:
                return False
            curr = curr.children[ord(char) - ord('a')]
        return curr.isEnd == True


    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for char in prefix:
            if curr.children[ord(char) - ord('a')] is None:
                return False
            curr = curr.children[ord(char) - ord('a')]
        return True



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)