# Time Complexity : O(n) to construct the trie
# Space Complexity : O(n) to construct the trie
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We use a Trie to store rootWords. When we go through each word, we check for the presence of the 
# root word in the Trie. The moment a root word is found, use it, otherwise use the actual word.
class TrieNode:
    def __init__(self):
        self.ch = [0 for _ in range(26)]
        self.end = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insertRootWord(self, word):
        curr = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if not curr.ch[idx]:
                curr.ch[idx] = TrieNode()
            curr = curr.ch[idx]
        curr.end = True
    
    # Time Complexity : O(m) to search for the word where m is the length of the word
    # Space Complexity : O(1)
    def rootWord(self, word):
        curr = self.root
        acc = ""
        for c in word:
            if curr.end:
                return acc
            idx = ord(c) - ord('a')
            if not curr.ch[idx]:
                return word
            acc += c
            curr = curr.ch[idx]
        return word


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:
            trie.insertRootWord(word)
        return " ".join([trie.rootWord(word) for word in sentence.split(' ')])
            