# Time Complexity: O(n) where n is the length of the word
# Space Complexity: O(n) where n is the length of the word
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The Trie data structure is implemented here by using a TrieNode class which has a list of 26 children and a 
boolean isEnd. We iterate through a given word and add it in to the Trie by creating a new TrieNode at the 
character's position if not already present, and finally when at the end of a word we set the isEnd to True. 
For search and startsWith we iterate through the word and check if the character is present in the Trie, if 
not we return False, else we return True if we are at the end of the word for search and if we have iterated 
through the entire word for startsWith.
"""

class Trie:
    class TrieNode:
        def __init__(self):
            self.children = [None for i in range(26)]
            self.isEnd = False

    def __init__(self):
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            index = ord(c) - ord('a')
            if curr.children[index] == None:
                curr.children[index] = self.TrieNode()
            curr = curr.children[index]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            index = ord(c) - ord('a')
            if curr.children[index] == None:
                return False
            curr = curr.children[index]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(len(prefix)):
            c = prefix[i]
            index = ord(c) - ord('a')
            if curr.children[index] == None:
                return False
            curr = curr.children[index]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)