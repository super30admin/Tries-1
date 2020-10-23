class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        trie = {}
        
        for word in dictionary:
            temp = trie
            for w in word:
                
                if w not in temp:
                    temp[w] = {}
                temp = temp[w]
        
        word_list = sentence.split()
        
        out = []
        for word in word_list:
            temp = trie
            
            if word[0] not in temp:
                out.append(word)
                continue
            for i, w in enumerate(word):
                
                if w not in temp:
                    
                    if len(temp.items()) == 0:
                        out.append(word[:i])                        
                    else:
                        out.append(word)
                        
                    break
                temp = temp[w]
        return " ".join(out)
                
                
                
                
            