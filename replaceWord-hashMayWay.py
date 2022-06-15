'''
Time: 0(k) -- for dict to cal hash func where k is the len of str in a dictionary list
      0(n*k) -- where n is iterating the successor and k is iterating the root
Space: 0(n) -- build dictionary/has-map
Ran on leetcode: Yes 
'''

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        # create a hash-map/dictionary
        dict = {}
        
        # add roots to the hash-map/dictionary
        for root in dictionary:
            if root not in dict:
                dict[root] = None
        
        # iterate the "sentence" and compare "successor's" root is available as a key
        
        # convert sentence into list
        sentence = sentence.split(" ")
        
        # pick the successor from the sentence-list
        for index in range(0,len(sentence)):
            
            # create smallest root
            for itr in range(0,len(sentence[index])):
                # fixed-ptr
                idx = 0
                # build a subString
                subString = sentence[index][idx:itr+1]
                # check if subString is a "root"
                if subString not in dict:
                    continue
                else:
                    sentence[index] = subString
                    break
                    
        '''end of for-loops'''
        sentence = " ".join(sentence)
        
        return sentence