class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.child = [None]*26    
        

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for char in word:
            if node.child[ord(char) - ord('a')] == None:
                node.child[ord(char) - ord('a')] = TrieNode()
                
            node = node.child[ord(char) - ord('a')]
        node.isEnd = True
        
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:
            trie.insert(word)
            
        
        def finder(trie, word):
            node = trie.root 
            k = 0
            while(node):
                if node.isEnd == True:
                    return (True,k)
                
                ch_check = False
                for i in range(26):
                    if node.child[i] != None and chr(ord('a')+i) == word[k]:
                        ch_check = True
                        node = node.child[i]
                        k = k + 1
                if ch_check == False:
                    return False, -1
            return False, -1
        
        final_string = " "
        for word in sentence.split(' '):
            res, k = finder(trie, word)
            if res:
                final_string = final_string + word[:k] + " "
            else:
                final_string = final_string + word + " "
        return final_string.strip()        
            
            
