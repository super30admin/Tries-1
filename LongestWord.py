# Time Complexity : O(NLogN) 
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA
# Approach is to go by hashset approach by find the longest word by finding the existing lexical ordered word alphabets in given dictionary.

# Approach is to 
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