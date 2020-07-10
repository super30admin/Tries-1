"""
// Time Complexity : O(L), where L is the avg length of word
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
"""

class TrieNode: #structure of a node
    def __init__(self):
        self.isEnd = False #tells if its the end of a word
        self.children = [None for _ in range(26)] #each node can have 26 possible children (lowercase alpabets)
        
class Trie(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None

        
        """
        cur = self.root
        for i in word: #insert the word in trie, characterwise
            idx = ord(i) - ord('a') #position of that character in children
            if not cur.children[idx]: # if character not present
                node = TrieNode() #create a new trie node and insert at that location
                cur.children[idx] = node
            cur = cur.children[idx] # move cur to its child
            
        cur.isEnd = True # when insertion of word is complete, update the isEnd varaible to mark the end of the word 

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        cur = self.root
        for i in word: #for each character in the word
            idx = ord(i) - ord('a')
            if not cur.children[idx]: #if any character is absent, return false right away
                return False
            cur = cur.children[idx]
            
        if cur.isEnd == True: #if at the end, complete word is found trie, then return true
            return True

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        cur = self.root
        for i in prefix:
            idx = ord(i) - ord('a')
            if not cur.children[idx]: #if any character is absent, return false right away
                return False
            cur = cur.children[idx]
        return True #if entire prefix has been traversed, return true



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)