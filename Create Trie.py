# // Time Complexity : O(l) l: length of word
# // Space Complexity : O(l)  ?
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : What is space complexity


# // Your code here along with comments explaining your approach
# Use the hashmap or array of length 26
# create tree of these nodes
# actual values wont be stored but the object will be stored in these array or hashmap
# into this object we keep track of End of the word using isEnd variable
# isEnd is False at start whenever we reach at end of the word we make it true

class TrieNode:
    def __init__(self):
        # to know if word is complete
        self.isEnd = False
        # map of characters
        self.chars ={}
        
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
        for i in word:
            if i not in node.chars:
                node.chars[i] = TrieNode()
            # go to next level in tree
            node = node.chars[i]
        # finally make the leaf true
        node.isEnd = True 
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root
        for i in word:
            if i not in node.chars: return False
            node = node.chars[i]
        return node.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        for i in prefix:
            if i not in node.chars: return False
            node = node.chars[i]
        # if we did not return yet it means we have traversed all the prefix and its in the dictionary
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)