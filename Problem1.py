# Time Complexity : O(n) n = length of word
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class TrieNode:
    def __init__(self):
        self.childrens = [False] * 26
        self.end = False 
        
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
        node = self.root 
        for ch in word:
            indx = ord(ch) - ord('a') # to access the index of childrens array
            if node.childrens[indx] == False:
                node.childrens[indx] = TrieNode() # New trie datastructure at that place 
            node = node.childrens[indx] # point the node to new structure 
        node.end = True # end of word 
            

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root 
        for ch in word:
            indx = ord(ch)-ord('a')
            if node.childrens[indx] == False: # not present 
                return False 
            else:
                node = node.childrens[indx]
        return node.end == True
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        for ch in prefix:
            indx = ord(ch) - ord('a')
            if node.childrens[indx] == False:
                return False 
            else:
                node = node.childrens[indx]
        return True 


if __name__ == "__main__":
    s = Trie()
    s.insert("apple")
    print(s.search("app"))
    print(s.search("apple"))
    print(s.startsWith("app"))