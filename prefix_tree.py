# Time Complexity:O(n) (where n = len of word)
# Space Complexity:O(n) (where n = len of the word) - insert operation
# Space Complexity:O(1) rest of the operations except insert operation
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children =[None]*26

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root= TrieNode()
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for i in range(len(word)):
            char = word[i]
            if curr.children[ord(char)-ord('a')]==None:
                curr.children[ord(char)-ord('a')] = TrieNode()
                
            curr = curr.children[ord(char)-ord('a')]
        
        curr.isEnd = True
            

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for i in range(len(word)):
            char = word[i]
            if curr.children[ord(char)-ord('a')] == None:
                return False
            
            curr = curr.children[ord(char)-ord('a')]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for i in range(len(prefix)):
            char = prefix[i]
            if curr.children[ord(char)-ord('a')] == None:
                return False
            
            curr = curr.children[ord(char)-ord('a')]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)