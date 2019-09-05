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