# Time complexity - O(nl)
# Space complexity - O(nl)
# Did this solution run on leetcode? - yes

from collections import defaultdict

class Solution:
    def longestWord(self, words: List[str]) -> str:
        wordSet = set()
        hashWord = defaultdict(lambda: [])
        
        for word in words:          # O(n)
            hashWord[len(word)].append(word)
            wordSet.add(word)
            
        for l in sorted(hashWord, reverse=True):    # O(n)
            for word in sorted(hashWord[l]):
                wordFound = True
                w = ""
                for ch in word:                 # O(l)
                    w+=ch
                    if w not in wordSet:
                        wordFound = False
                        break
                if wordFound: 
                    return word
        return None
                
    
# Time complexity - O(nl)
# Space complexity - O(nl)
# Did this solution run on leetcode? - yes
from collections import defaultdict
class Solution:
    def longestWord(self, words: List[str]) -> str:
        Trie = lambda: defaultdict(Trie) 
        trie = Trie()
        
        for i, word in enumerate(words):
            reduce(dict.__getitem__, word, trie)[True] = i
            
            
        stack = list(trie.values())
        ans = ""
        while stack:
            curr = stack.pop()
            if True in curr:
                idx = curr[True]
                word = words[idx]
                if len(word) > len(ans) or len(word) == len(ans) and word < ans:
                    ans = word
                stack.extend([curr[letter] for letter in curr if letter!=True])
    
        return ans


# Time complexity - O(n*w^2)
# Space complexity - O(n*w^2)
# Did this solution run on leetcode? - yes
class Solution:
    def longestWord(self, words: List[str]) -> str:
        hashSet = set(words)
        
        ans = ""
        for word in words:
            if len(word) > len(ans) or (len(word) == len(ans) and word < ans):
                if all(word[:k] in hashSet for k in range(1, len(word))):
                    ans = word
        return ans
        