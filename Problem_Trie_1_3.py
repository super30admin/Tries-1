class Solution:



	def replaceWords(self, dict: List[str], sentence: str) -> str:



		# Time Complexity : O(mn) where m is the length of the dict and n is the number of words present in the sentence



		# Space Complexity : O(N*K)



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
