'''
TC: O(n * w + sw * w)
SC: O(n * w)
w - words in dictionary, sw - words in sentence
'''
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if not dictionary or not sentence:
            return sentence
        
        trie = dict()
        
        for word in dictionary:
            fakehead = trie
            for char in word:
                fakehead[char] = fakehead.get(char, dict())
                fakehead = fakehead[char]
            fakehead["."] = dict()
            
        f = ""
        
        for word in sentence.split(" "):
            fakehead = trie
            final = None
            sofar = ""
                
            for char in word:
                if char not in fakehead:
                    if "." in fakehead:
                        final = sofar
                    else:
                        final = word
                    break
                sofar += char
                fakehead = fakehead[char]
                if "." in fakehead:
                    final = sofar
                    break
            
            if final == None:
                final = word
                
            f += final + " "
        
        return f[:-1]