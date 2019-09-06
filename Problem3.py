class Solution:
	def replaceWords(self, dict: List[str], sentence: str) -> str:
		# Time Complexity : O(mn) where m is the length of the dict and n is the number of words present in the sentence
		# Accepted on leetcode
		res = []
		sentence = sentence.split(" ")
		for i in sentence:
			temp = []
			for j in dict:
				if i.startswith(j):
					temp.append(j)
			if len(temp) == 0:
				res.append(i)
			elif len(temp) == 1:
				res.append(temp[0])
			else:
				res.append(min(temp, key = lambda x:len(x)))
		res = " ".join(res)
		return res

class Solution:
	# Time Complexity : O(mn) where m is the number of words in the dict and n is the number of words in the sentence (is this correct??)
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