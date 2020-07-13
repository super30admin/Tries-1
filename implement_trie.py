

# Time Complexity : Add - O(mn) - m=no. of words, n = avg length of a word
# Space Complexity :O(n) - avf length of a word
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. create TrieNode Abstrac data type with attributes as chilren array sized 26, and a isEnd Flag
2. For each word that comes in, start with firts letter and if letter doesn't exist, initialize a new TrieNode
If it exists move forward, at the end of word, make the isEnd Flag True
3. searching is looping thru each level, by accesing ascii value - ascii('a')
4. To check prefix, the flag doesn't needs to be checked
'''

class TrieNode():
    
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False
    


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        current = self.root
        for i in word:
            if current.children[ord(i)-ord('a')] is None:
                current.children[ord(i)-ord('a')] = TrieNode()
                
            current = current.children[ord(i)-ord('a')]
        current.isEnd = True
                
    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        
        current = self.root
        for i in word:
            if current.children[ord(i)-ord('a')]:
                current = current.children[ord(i)-ord('a')]                   
            else:
                return False
        if current.isEnd:
            return True
        return False
            
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        current = self.root
        for i in prefix:
            if current.children[ord(i)-ord('a')]:
                current = current.children[ord(i)-ord('a')]                   
            else:
                return False
            
        return True
        
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)