# TC: O(n*p + m*q) 
#       where n is number of words in dictionary, 
#             p is word length in dictionary
#             m is the number of words in the sentence
#             q is word length in sentence
# SC: O(n*p) for the Trie
# LeetCode: Y(https://leetcode.com/problems/replace-words/)
# Approach: Build a trie of the words in the dictionary.
#           is_last_char is an attribute of TrieNode to indicate the end of root word
#           Check if each word in the sentence is a root by traversing the trie character by character

class TrieNode:
    def __init__(self):
        self.is_last_char = False
        self.children = [False for _ in range(26)]

class Solution:
    
    def populateTrie(self, word):
        
        # variable current to track the current TrieNode 
        current = self.root
        
        # Traverse the word character by character
        for character in word:
            
            # if the TrieNode for current character is not initialized then initialize it
            if not current.children[ord(character) - ord('a')]:
                current.children[ord(character) - ord('a')] = TrieNode()
                
            # Move current
            current = current.children[ord(character) - ord('a')]
            
        # mark the last charcter
        current.is_last_char = True
            
    def get_root(self, word):
        
        # variable current to track the current TrieNode 
        current = self.root
        
        # track the word as the Trie is traversed
        root_word = ""
        
        # Traverse the word character by character
        for character in word:
         
            # if the character of word is present in Trie
            if current.children[ord(character) - ord('a')]:
                
                # if root is found
                if current.children[ord(character) - ord('a')].is_last_char :
                    return root_word + character
                
                # if root is not found yet then update current and root_word
                else:
                    root_word += character
                    current = current.children[ord(character) - ord('a')]
                    
            # charcter is not present in Trie -> no matching root so return original word
            else:
                return word
        
        # return original word as no matching root is found
        return word
            
                
            
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        # intialize Trie
        self.root = TrieNode()
        
        # insert each word of dictionary in Trie
        for word in dictionary:
            self.populateTrie(word)
        
        # list to store root words
        roots = []
        
        # loop over each word in the sentence
        for word in sentence.split(" "):
            
            # get the root if root exists
            roots.append( self.get_root(word) )
        
        # convert list to string
        return " ".join(roots)
        
        
