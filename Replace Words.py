# Time Complexity :
# TC: O(nl + mk)

# Space Complexity :
# SC: O(nl) --> sapce for trie

# n is number of words in dictionary and l is length of each word in dictionary
# m is number of words in sentence and k is length of each word in sentence

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach
# First i have created a trie containing the dictionary
# Then i have searched for each word in the sentence in trie
# If trie consist of prefix of that word i have replaced the word with prefix
# otherwise i replaced the word with the word itself

class Solution:
    
    
    # TC: O(nl + mk)
    # SC: O(nl)
    # n is number of words in dictionary and l is length of each word in dictionary
    # m is number of words in sentence and k is length of each word in sentence
    
    class TrieNode:
        
        def __init__(self):
            self.isEnd = False
            self.children = [None for i in range(26)]
    
    root = None
    def insert(self, word):
        curr = self.root
        
        for char in word:
            if curr.children[ord(char) - ord('a')] == None:
                curr.children[ord(char) - ord('a')] = self.TrieNode()
            curr = curr.children[ord(char) - ord('a')]
            
        curr.isEnd = True
            
            
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        self.root = self.TrieNode()
        
        for word in dictionary:
            self.insert(word)
        
        senList = sentence.split(" ")
        
        result = ""
        
        for i in range(len(senList)):
            word = senList[i]
            curr = self.root
            replacement = ""
            for char in word:
                if (curr.children[ord(char) - ord('a')] == None) or (curr.isEnd == True):
                    break
                curr = curr.children[ord(char) - ord('a')]
                replacement += char
            
            if (i != 0):
                if (curr.isEnd):
                    result += " " + replacement
                else:
                    result += " " + word
            else:
                if (curr.isEnd):
                    result += replacement
                else:
                    result += word
            
        
        return result