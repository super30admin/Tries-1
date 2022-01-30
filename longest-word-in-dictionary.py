'''
TC: O(nlogn + n * w) - w avg word length
SC: O(n * w)
'''
class Solution:
    def longestWord(self, swords: List[str]) -> str:
        if not swords:
            return ""
        
        
        trie = dict()
        ml = 0
        mw = ""
        
        words = sorted(swords)
        
        for word in words:
            l = 0
            fakehead = trie
            dots = 0
            for char in word:
                fakehead[char] = fakehead.get(char, dict())
                if "." in fakehead:
                    dots += 1
                fakehead = fakehead[char]
                l += 1
                
            fakehead["."] = dict()
            
            if dots == l - 1:
                if l > ml:
                    ml = l
                    mw = word
                elif l == ml:
                    if word < mw:
                        mw = word
                        
        return mw