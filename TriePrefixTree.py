# Time Complexity: O(L) L is the length of the word
# Space Complexity: O(L) L is the length of the word
class TrieNode:
	def __init__(self, val):
		self.val = val
		self.children = [None]*26
		self.isword = False

class Trie:

    def __init__(self):
        self.root = TrieNode(" ")

    def insert(self, word: str) -> None:
        temp = self.root
        for i in word:
            node = TrieNode(i)
            if temp.children[ord(i) - ord('a')] == None:
                temp.children[ord(i) - ord('a')] = node
            temp = temp.children[ord(i) - ord('a')]
        temp.isword = True

    def search(self, word: str) -> bool:
        temp = self.root
        for i in word:
            if temp.children[ord(i) - ord('a')] == None:
                return False
            temp = temp.children[ord(i) - ord('a')]
        return temp.isword

    def startsWith(self, prefix: str) -> bool:
        temp = self.root
        for i in prefix:
            if temp.children[ord(i) - ord('a')] == None:
                return False
            temp = temp.children[ord(i) - ord('a')]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)