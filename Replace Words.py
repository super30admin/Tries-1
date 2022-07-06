# TC/SC: O(M*N)/O(M)
class Trie:
    def __init__(self):
        self.trieStorage = {}
        self.endCharacter = '*' 

    def insert(self, word) :
        node = self.trieStorage
        for i in word:
            if i not in node:
                node[i] = {}
            node = node[i]
        
        node[self.endCharacter] = True
                
        
    def search(self, word):
        node = self.trieStorage
        for i in word:
            if i not in node:
                return False
            node = node[i]
        
        return self.endCharacter in node
        

class Solution(object):
    def replaceWords(self, dictionary, sentence):
        trie = Trie()
        for word in dictionary:
            trie.insert(word)
            
        str_ = sentence.split()
        result = []
        
        for word in str_:
            word_updated = ""
            node = trie.trieStorage
            for idx,s in enumerate(word):
                if trie.search(word[:idx+1]):
                    word_updated = word[:idx+1]
                    break
            if word_updated != "":
                result.append(word_updated)
            else:
                result.append(word)
        
        return ' '.join(result)
