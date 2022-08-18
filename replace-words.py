"""
Runtime Complexity:
O(n*l) + O(m*k) - where 'n' is the number of words in the dictionary and 'l' is the average length of the words, 'm' is the number of words in the sentence and 'k' is the average length.
We create a Trie tree from the words in word list. Then once we encounter a shorter word in the tree we just replace it.
Space Complexity:
O(n*l) - where 'n' is the number of words and 'l' is the average length of the words stored in Trie tree.
Yes, the code worked on leetcode.
Issues while coding- No
"""


class TrieNode:
    def __init__(self):
        self.children = [0]*26
        self.wordEnd = False


class Solution:
    def __init__(self):
        self.root = TrieNode()

    def insert(self,word):  # add each word to trie tree.
        curr = self.root
        for char in word:
            c = ord(char) - ord('a')
            if not curr.children[c]:
                curr.children[c] = TrieNode()
            
            curr = curr.children[c]
        curr.wordEnd = True
    
    def search(self,word):
        curr = self.root
        st = ""
        for char in word:
            c = ord(char) - ord('a')
            if not curr.children[c]:    #if the word is not found, then we dont replace it.
                return ""
            st+=char
            curr = curr.children[c]
            
            if curr.wordEnd == True:    #when the word is found we return it which cointains the word appended.
                return st
        return ""
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
            self.insert(word)
        sList = sentence.split()
        final = ""
        for i in range(len(sList)):
            if i!=0:            #to create space between words. When 'i' increments this creates space. 
                final+=" "
            strs = sList[i]
            res = self.search(strs)
            
            if res!="":
                final+=res
            else:
                final+=strs
        return final
         