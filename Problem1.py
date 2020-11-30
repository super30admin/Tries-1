class Trie:
	# Accepted on leetcode
	def __init__(self):
		"""
		Initialize your data structure here.
		"""
		self.triedict = dict()

	def insert(self, word: str) -> None:
		# Time Complexity : O(1) its constant
		"""
		Inserts a word into the trie.
		"""
		self.triedict[word] = 1

	def search(self, word: str) -> bool:
		# Time COmplexity : O(n) where n is the number of elements in the trie
		"""
		Returns if the word is in the trie.
		"""
		for i in self.triedict.keys():
			if word == i:
				return True
		return False
		

	def startsWith(self, prefix: str) -> bool:
		# Time Complexity : O(n) where n is the number of elements in the trie
		"""
		Returns if there is any word in the trie that starts with the given prefix.
		"""
		for i in self.triedict.keys():
			if i.startswith(prefix):
				return True
		return False


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

class TrieNode:
	def __init__(self, val):
		self.val = val
		self.children = [None]*26
		self.isword = False

class Trie:

	def __init__(self):
		"""
		Initialize your data structure here.
		"""
		self.root = TrieNode(" ")

	def insert(self, word: str) -> None:
		"""
		Inserts a word into the trie.
		"""
		temp = self.root
		for i in word:
			node = TrieNode(i)
			if temp.children[ord(i) - ord('a')] == None:
				temp.children[ord(i) - ord('a')] = node
			temp = temp.children[ord(i) - ord('a')]
		temp.isword = True

	def search(self, word: str) -> bool:
		"""
		Returns if the word is in the trie.
		"""
		temp = self.root
		for i in word:
			if temp.children[ord(i) - ord('a')] == None:
				return False
			temp = temp.children[ord(i) - ord('a')]
		return temp.isword

	def startsWith(self, prefix: str) -> bool:
		"""
		Returns if there is any word in the trie that starts with the given prefix.
		"""
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