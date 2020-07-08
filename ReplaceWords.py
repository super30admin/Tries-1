---------------------------------Replace Words -------------------------------------
# Time Complexity : O(NXL+ML) N is the number of sentence , L is the average length of the words in sentence and M is the number of words in a dict, L is the average length of the word.
# Space Complexity : O(ML)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here I have used array to implement trie data-structure. I have created a trie will all the given words by creating new array in the 
#index of ascii number of the character. Once we create a trie, we will process each and every node with its children node comparing with the word in a given string.
#If the prefix matches we will iterate through that node until we reach the first end of the word.




class TrieNode(object):
    def __init__(self):
        self.children= [None]*26
        self.isEnd = False

        
class Trie(object):
    def __init__(self):
        self.root=TrieNode()
        
    def insert(self, word):
        node=self.root
        for c in word:
            if node.children[ord(c)-ord('a')] == None:
                node.children[ord(c)-ord('a')] = TrieNode()
            node = node.children[ord(c)-ord('a')]
        node.isEnd=True
    
    def replaceWords(self, word):
        node = self.root
        temp = ''
        for c in word:
            if node.children[ord(c)-ord('a')] == None or node.isEnd == True:
                break
            else:
                temp += c
                node = node.children[ord(c)-ord('a')]
        if node.isEnd:
            return temp
        else:
            return word
            

                

class Solution:
    def replaceWords(self, dict: List[str], sentence: str) -> str:
        s = sentence.split(" ")
        trie = Trie()
        for w in dict:
            trie.insert(w)
            
        for w in range(len(s)):
            t = trie.replaceWords(s[w]) 
            s[w] = t
        return " ".join(s)
    
        
        