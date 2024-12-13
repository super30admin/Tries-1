# The replaceWords method replaces words in a sentence with their shortest root from a dictionary.

# A Trie is used to efficiently store and search roots.
# addWord inserts each root into the Trie.
# getRoot finds the shortest root for a given word or returns the word itself if no root exists.

# Insert all dictionary roots into the Trie.
# Split the sentence into words, replacing each word with its root using getRoot.
# Join and return the modified sentence.

# TC: O(n + m) - n for inserting dictionary roots, m for processing the sentence.
# SC: O(n) - Space for the Trie structure.


from typing import List


class Trie:
    def __init__(self):
        self.children = {} 
        self.endOfWord = False

    
class Solution:
    def __init__(self):
        self.root = Trie() 

    def addWord(self,word): 
        curr = self.root
        for c in word:
            if c not in curr.children:
                curr.children[c] = Trie()
            curr = curr.children[c]
        curr.endOfWord = word

    def getRoot(self,word):
        curr = self.root
        for c in word:
            if c not in curr.children:
                return word
            curr = curr.children[c]
            if curr.endOfWord:
                return curr.endOfWord
        return word

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary: 
            self.addWord(word) 

        words = sentence.split(" ") 
        for i,word in enumerate(words): 
            words[i] = self.getRoot(word) 

        return ' '.join(words)


        