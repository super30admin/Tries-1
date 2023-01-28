#time O(N)
#space O(N)

class Solution:
    def longestWord(self, words: List[str]) -> str:
#         dict={}
#         cur={}
#         for ch in words:
#             if ch not in cur:
#                 dict[ch]={}
#             cur=dict[ch]
#         dict["*"]=True 
#         print(dict)
        dic = sorted(words, key = lambda x: (-len(x), x))
        # print(dic)
        for word in dic:
            t = 0
            for i in range(len(word)-1):
                # print(i)
                if word[:i + 1] not in dic:
                    # print(word[:i+1])
                    t = 1
            if t == 0:
                return word