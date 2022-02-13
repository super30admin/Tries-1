#Time Complexity O(N^2)
#Space Complexity O(N)

class Solution:
    def replaceWords(self, roots, sentence):
        rootset = set(roots)

        def replace(word):
            for i in range(1, len(word)):
                if word[:i] in rootset:
                    return word[:i]
            return word

        return " ".join(map(replace, sentence.split()))
            
            
                    
            
        
