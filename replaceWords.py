# Appproach: Build a trie node with dictionary words and split the sentence, iterating iver evry word checking for the charac in the trienode
# As long as the characters are found in child nodes of trie node and current.end is not true we keep adding the characters to a replacement string
# Once we hit any of the above we break and evaluate those conditions
# Time - O(M * N + K * P) where M and N are the word length and number of words in dict and K is the total words in sentence each with length P
# Space - O(MN)
class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False
    
class Solution:
    
    def insert(self, word):
        
        current = self.root
        for w in word:
            if current.children[ord(w) - ord('a')] == None:
                current.children[ord(w) - ord('a')] = TrieNode()
            current = current.children[ord(w) - ord('a')]
            
        current.isEnd = True
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        if not dictionary or len(dictionary) == 0:
            return sentence
        
        self.root = TrieNode()
        
        for word in dictionary:
            self.insert(word)
            
        sentence_split = sentence.split()
        result = []
        
        for i in range(len(sentence_split)):
            word = sentence_split[i]
            if i > 0:
                result.append(" ")
            
            current = self.root
            replacement = []
            
            for c in (word):
                if current.children[ord(c) - ord('a')] == None or current.isEnd:
                    break
                # if we are cont
                replacement.append(c) 
                current = current.children[ord(c) - ord('a')]
                
        
            if current.isEnd:
                result.append("".join(replacement))

            else:
                result.append(word)

        return "".join(result)
            
        
        