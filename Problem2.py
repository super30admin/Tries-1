# Time Complexity :  max(O(N Log(N)), O(N * K)) K: Length of the longest word
# Space Complexity: N * K where K: Length of the longest word
# Passed Leetcode 
class Solution:
    
            
    def longestWord(self, words: List[str]) -> str:
        
        trie = {}
        max_word = ""
        
        if len(words) == 0:
            return max_word
        
        word_len = [(len(word), word) for word in words]
        
        word_len.sort()
        
        for length, word in word_len:
            
            valid = True
            temp = trie
            for i, w in enumerate(word):
                
                if w not in temp:
                    
                    if i != len(word) - 1:
                        valid = False
                        break
                    temp[w] = {}
                    
                temp = temp[w]
                
                        
            if valid:
                
                  if len(word) > len(max_word):
                        max_word = word
                
        # print(trie)
        return max_word