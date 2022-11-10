class TrieNode:
    def __init__(self):
        self.children = {}
        self.end_of_word = False
    
class Trie:
    def __init__(self):
        self.root = TrieNode()
        
    # Time Complexity: O(total words in dictionary * avg length of word)
    # Space Complexity: O(total words in dictionary * avg length of word)
    def insert(self, word: str) -> None:
        
        curr = self.root
        
        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        curr.end_of_word = True
    
    # O (total_words_in_sentence * avg_length_of_word)
    def find(self, word: str) -> None:
        
        curr = self.root
        result = ""
        for c in word:
            if c not in curr.children:
                break
                
            
            curr = curr.children[c]
            result += c
            if curr.end_of_word:
                return result
            
        return word
            
    
    

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        sent_split = sentence.split()
        trie = Trie()
        for words in dictionary:
            trie.insert(words)
        
        result = ""    
        for word in sent_split:    
            if result:
                result += " "
            result += trie.find(word)
            
        return result