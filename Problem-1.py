#Time Complexity :o(nm) m is avg lenght of n words
#Space Complexity :o(mn) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class TrieNode():
    children=None
    isTrue=None
    def __init__(self):
        self.children=[None]*26
        self.isTrue=False

class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root=TrieNode()
        
    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        curr=self.root
        for i in word:
            if(curr.children[ord(i)-ord('a')]==None):
                #print('yes',curr.children[0])
                curr.children[ord(i)-ord('a')]=TrieNode()
            curr=curr.children[ord(i)-ord('a')]
        curr.isTrue=True
                
    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        curr=self.root
        for i in word:
            if(curr.children[ord(i)-ord('a')]==None):
                return False
            curr=curr.children[ord(i)-ord('a')]
        return curr.isTrue
        

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        curr=self.root
        for i in prefix:
            if(curr.children[ord(i)-ord('a')]==None):
                return False
            curr=curr.children[ord(i)-ord('a')]
        return True
        
