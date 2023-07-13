'''
Problem: Implement Trie (Prefix Tree)
Time Complexity: O(n), where n is length of word
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        initialise TrieNode for every character of the word
        move to children and if word finished mark isEnd = True
'''

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            idx = ord(word[i]) - ord('a')
            if curr.children[idx] == None:
                curr.children[idx] = TrieNode()
            curr = curr.children[idx]
        curr.isEnd = True
        
    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(len(word)):
            idx = ord(word[i]) - ord('a')
            if curr.children[idx] == None:
                return False
            curr = curr.children[idx]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(len(prefix)):
            idx = ord(prefix[i]) - ord('a')
            if curr.children[idx] == None:
                return False
            curr = curr.children[idx]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)