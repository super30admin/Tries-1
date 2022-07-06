# TC/SC: O(M* N)/O(M * N)
# M - number of words and n is max length of the word
class Trie:

    def __init__(self):
        self.trieStorage = {}
        self.endCharacter = '*'
        

    def insert(self, word: str) -> None:
        node = self.trieStorage
        for i in word:
            if i not in node:
                node[i] = {}
            node = node[i]
        
        node[self.endCharacter] = True
                
        
    def search(self, word: str) -> bool:
        node = self.trieStorage
        for i in word:
            if i not in node:
                return False
            node = node[i]
        
        return self.endCharacter in node
        

    def startsWith(self, word: str) -> bool:
        node = self.trieStorage
        for i in word:
            if i not in node:
                return False
            node = node[i]
        
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for word in words:
            trie.insert(word)
        max_word = ''
        for word in words:
            node = trie.trieStorage
            flag = False
            for i in word:
                if "*" not in node[i]:
                    flag = True
                    break
                node = node[i]
            if flag :
                continue
            if len(word) >= len(max_word):
                if len(word) == len(max_word):
                    max_word = max_word if max_word < word else word
                else:
                    max_word = word
                
        return max_word
            
            
                
        
            
        
