#Time Complexity: O(W + NlogN) 
#Space Complexity: O(26*N*W)
#It successfully runs on leetcode 

class trieNode:
    def __init__(self,value):
        self.children = {}
        self.isend= False
        self.val = value
class Solution:
           
    def longestWord(self, words: List[str]) -> str:
        root = trieNode(0)
        maxlen, res = 0, ""
        
        for word in sorted(words):
            cur = root
            count = 0
            for c in word:
                if c not in cur.children:
                    cur.children[c] = trieNode(count)
                cur = cur.children[c]
                if cur.isend: count += 1
                    
            cur.isend = True
            cur.val += 1
            
            if cur.val == len(word) and cur.val > maxlen:
                maxlen = cur.val
                res = word
            
        return res

#Time Complexity of search and startss with O(W^2) 
#Space Complexity O(N + W)
#It successfully runs on leetcode
class Solution:
    def longestWord(self, words: List[str]) -> str:
        s = set()
        res= ""
        for word in sorted(words):
            if len(word)==1 or word[:len(word)-1] in s:
                if len(res) < len(word): res = word
                s.add(word)
        return res
[]