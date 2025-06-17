# Time Complexity : O(NLogN) 
# Space Complexity : O(N) 

class Solution:
    def longestWord(self, words: List[str]) -> str:
        words.sort()                  
        visited ={""}                
        res = ''

        for word in words:
            if word[:-1] in visited:     
                visited.add(word)        
                if len(word) > len(res): 
                    res = word           
        return res  