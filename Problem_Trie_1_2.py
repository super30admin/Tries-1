class Solution:

	def longestWord(self, words: List[str]) -> str:

		trie = Trie()

		for index, word in enumerate(words):

			trie.insert(word, index + 1)

		return trie.dfs(words)

class TrieNode:

	def __init__(self, val):

		self.val = val

		self.index = 0

		self.children = dict()

class Trie:

	def __init__(self):

		self.root = TrieNode(" ")

	def insert(self, word, index):

		temp = self.root

		for i in word:

			node = TrieNode(i)

			if temp.children.get(i) == None:

				temp.children[i] = node

			temp = temp.children.get(i)

		temp.index = index

	def dfs(self, words):

		res = ""

		stack = []

		stack.append(self.root)

		while len(stack) > 0:

			node = stack.pop()

			if node.index > 0 or node == self.root:

				if node != self.root:

					word = words[node.index - 1]

					if len(word) > len(res) or len(word) == len(res) and res > word:

						res = word

				for i in node.children.values():

					stack.append(i)

		return res


#TC:O(nlogn)
#SC:O(n)