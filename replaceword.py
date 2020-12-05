# Time complexity - O(w+s) # w - total length of all the words. # s - length of the sentence.
# Space complexity - O(w) space for a trie 
# Did this solution run on leetcode? - yes
from collections import defaultdict
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        Trie = lambda: defaultdict(Trie)
        trie = Trie()
        end = True
        
        # create a trie
        for i, word in enumerate(dictionary):
            reduce(dict.__getitem__, word, trie)[end] = i
            
        ans = []
        for word in sentence.split(" "):
            curr = trie
            replaceWord = ""
            for ch in word:
                curr = curr[ch]
                replaceWord += ch
                if end in curr:
                    break
            ans.append(replaceWord)
        
        return " ".join(ans)
            
            