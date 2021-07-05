class TrieNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isend = False

class Solution:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
      

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur = self.root
        for i in range(len(word)):
            ch = word[i]
            if not cur.children[ord(ch) - ord('a')]:
                cur.children[ord(ch)-ord('a')] = TrieNode() 
            cur = cur.children[ord(ch)-ord('a')]
        cur.isend = True

    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        """
        TC: O(m*n), m = len(max(keylen)), n= len(sentence)
        SC:O(size_of_trie)
        """
        
        for word in dictionary:
            self.insert(word)
        
        # return tokenized list
        splitted = sentence.split()
        res = []
        
        for word in splitted:
            replacement = ""
            cur = self.root
            for i in range(len(word)):
                ch = word[i]
                if cur.children[ord(ch)-ord('a')] is None or cur.isend:
                    break
                
                cur = cur.children[ord(ch) - ord('a')]
                replacement += ch

            if cur.isend:
                res.append(replacement)
            else:
                res.append(word)
        
        return " ".join(res)
        