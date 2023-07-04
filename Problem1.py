# Time Complexity : O()
# Space Complexity : O()
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We use TrieNode objects which have a flag that marks whether we have reached the end of a word.
# We also have an array of size 26 that represents the children TrieNode representing the next letter in the word we are parsing. 
# For search word, we traverse until children is not found or the last character has flag set to True.
# For startsWith, we traverse until children is not found or we finish traversing all the characters in the Trie successfully.
class TrieNode:
    def __init__(self):
        self.ch = [0 for _ in range(26)]
        self.end = False

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            idx = ord(c)-ord('a')
            if not curr.ch[idx]:
                curr.ch[idx] = TrieNode()
            curr = curr.ch[idx]
        curr.end = True
        

    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            idx = ord(c)-ord('a')
            if not curr.ch[idx]:
                return False
            curr = curr.ch[idx]
        return curr.end

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            idx = ord(c)-ord('a')
            if not curr.ch[idx]:
                return False
            curr = curr.ch[idx]
        return True
