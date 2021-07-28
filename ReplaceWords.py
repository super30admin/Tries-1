# TC: O(N.k + M.k) where M is the number of words in the dictionary and the k is the average length of the words in dictionary. M is the number of words present in the sentence.
# SC: O(N.k) which will be the space required to store the words from the dictionary into the trie.

class TrieNode: 
    def __init__(self): 
        self.children = {}
        self.isEnd = False
        
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if not dictionary or len(dictionary) == 0: 
            return sentence
        
        self.root = TrieNode()
        sentence_list = sentence.split()
        
        result = ""
#         iterate over words in dictionary and insert into trie
        for word in dictionary:
            self.insertInTrie(word)
        
        for word in sentence_list:
            prefix = self.returnPrefix(word)
            result += " " + prefix
        
        return result.lstrip()
    
    def insertInTrie(self, word: str):
        curr = self.root
        for char in word: 
            if char not in curr.children: 
                curr.children[char] = TrieNode()
            curr = curr.children.get(char)
        
        curr.isEnd = True
    
    def returnPrefix(self, word: str) -> str: 
        curr = self.root
        if word[0] not in curr.children: 
            return word
        
        prefix = ""
        for char in word: 
            if char in curr.children: 
                prefix += char
                if curr.children.get(char).isEnd:
                    return prefix
                curr = curr.children.get(char)
            else: 
                return word
            
        if not curr.isEnd: 
            return word
        return prefix
    
