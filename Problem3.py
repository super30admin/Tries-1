# Time Complexity :  O(N) Sum of all characters in the sentence
# Space Complexity: O(N)
# Passed Leetcode 

class TrieNode:
    
    def __init__(self):
        
        self.valid = False
        
        self.next_nodes = [None for i in range(26)]
        
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        trie = TrieNode()
        
        dict_set = set()
        for word in dictionary:
            temp = trie
            for w in word:
                if not temp.next_nodes[ord(w) - 97]:
                    temp.next_nodes[ord(w) - 97] = TrieNode()
                    
                temp = temp.next_nodes[ord(w) - 97]
            temp.valid = True
            
        word_list = sentence.split(" ")
        
        out = []
        for word in word_list:
            temp = trie
            if not temp.next_nodes[ord(word[0]) - 97]:
                out.append(word)
                continue
            
            out_word = word
            for i, w in enumerate(word):   
                if temp.valid:
                    out_word = word[:i]
                    break
                if not temp.next_nodes[ord(w) - 97]:
                    break
                
                temp = temp.next_nodes[ord(w) - 97]
            out.append(out_word)
        return " ".join(out)
                
                
                
                
            