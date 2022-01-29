# time complexity: O(nl)
# space complexity: O(nl)

class Solution:

	def replaceWords(self, dict: List[str], sentence: str) -> str:

		trie = Trie()
		words = sentence.split(" ")
		for word in dict:
			trie.insert(word)
		root = trie.getRoot()

		res = ""

		for word in words:
			temp = root
			replaceStr = ""
			flag = False
			for char in word:
				replaceStr += char
				if temp.children[ord(char) - ord('a')] == None:
					res += word + " "
					flag = True
					break
				temp = temp.children[ord(char) - ord('a')]

				if temp.isword:
					res += replaceStr + " "
					flag = True
					break
                    
			if not temp.isword and not flag:
				res += word + " "

		return res.strip()

class TrieNode:
	def __init__(self, val):

		self.val = val
		self.children = [None] * 26
		self.isword = False

class Trie:
	def __init__(self):
		self.root = TrieNode(" ")
        
	def getRoot(self):
		return self.root

	def insert(self, word):
		temp = self.root
		for i in word:
			if temp.children[ord(i) - ord('a')] == None:
				node = TrieNode(i)
				temp.children[ord(i) - ord('a')] = node
			temp = temp.children[ord(i) - ord('a')]
		temp.isword = True