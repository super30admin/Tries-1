# Time Complexity : O(k) where k is averange length of the word/Prefix while Searching or Inserting
# Space Complexity : O(k * N) where k is averange length of the word and N is number of words
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isLastChar = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for l in word:
            if curr.children[ord(l) - ord('a')] == None:
                curr.children[ord(l) - ord('a')] = TrieNode()
            curr = curr.children[ord(l) - ord('a')]
        curr.isLastChar = True
                
            

    def search(self, word: str) -> bool:
        curr = self.root
        for l in word:
            if curr.children[ord(l) - ord('a')] == None:
                return False
            curr = curr.children[ord(l) - ord('a')]
        return True if  curr.isLastChar else False

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for l in prefix:
            if curr.children[ord(l) - ord('a')] == None:
                return False
            curr = curr.children[ord(l) - ord('a')]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)