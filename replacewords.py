class TrieNode:
    
    def __init__(self):
        
        self.children = [None] * 26
        self.isEnd = False

class Solution:
    
    """
    Description: Given a dictionary consisting of roots and a sentence, replace all the successors in the sentence with the root forming it
    
    Time Complexicity: O(m*n + w*k)
    Space Complexicity: O(m*n + k) {to create the Trie for the given dictionary}
    
    where n is size of dictionary, m is average length of each word in dictionary, and
    k is average length of word in a sentence, w is number of words in given sentence
    
    Approach:
    - build a Trie using the given dictionary (https://leetcode.com/problems/implement-trie-prefix-tree/)
    - for each word in given sentence, find if the root of the word exist in the dictionary
      + add characters if root of the word exist (ensure .isEnd = True)
      + add original word if root of the word do not exits 
    - join all the results with a string at the end
    """
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        if dictionary == None or len(dictionary) == 0: return sentence

        self.root = TrieNode()
        for word in dictionary:
            self.insert(word)
            
        result = []
        given_words = sentence.split(" ")
        
        for i, word in enumerate(given_words):
            if i > 0: result.append(" ")
            replace_by = []
            currNode = self.root
            for i, char in enumerate(word):
                if currNode.children[ord(char) - ord("a")] == None or currNode.isEnd: break
                replace_by.append(char)
                currNode = currNode.children[ord(char) - ord("a")]
            
            if len(replace_by) and currNode.isEnd > 0:
                result.append("".join(replace_by))
            else: result.append(word)
            
        return "".join(result)
                
        
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        currNode = self.root
        for i, char in enumerate(word):
            if currNode.children[ord(char) - ord("a")] == None:
                currNode.children[ord(char) - ord("a")] = TrieNode()
            currNode = currNode.children[ord(char) - ord("a")]
        
        currNode.isEnd = True
