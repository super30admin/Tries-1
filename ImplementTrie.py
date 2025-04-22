# Time Complexity: O(L) 
# Space Complexity: O(L) 
# Does this code run on Leetcode: Yes
# Any problems faced while coding this: No


class TrieNode:
	def __init__(self, val):
		self.val = val
		self.children = [None]*26
		self.isEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode(" ")

    def insert(self, word: str) -> None:
        curr = self.root
        for i in word:
            node = TrieNode(i)
            if curr.children[ord(i) - ord('a')] == None:
                curr.children[ord(i) - ord('a')] = node
            curr = curr.children[ord(i) - ord('a')]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        curr = self.root
        for i in word:
            if curr.children[ord(i)-ord('a')] == None:
                return False
            curr = curr.children[ord(i)-ord('a')]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in prefix:
            if curr.children[ord(i)-ord('a')] == None:
                return False
            curr = curr.children[ord(i)-ord('a')]
        return True