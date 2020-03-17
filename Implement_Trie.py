// Time Complexity : insert- o(n) ,search- o(n), startswith - o(n)
// Space Complexity :insert - o(1),search- o(1),startswith -o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class TrieNode:
    def __init__(self):
        self.isEnd=False
        self.children=[None for i in range(26)] 

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
        root1=self.root
        for i in range(len(word)):
            index=ord(word[i])-ord('a')
            if root1.children[index]==None:
                root1.children[index]=TrieNode()
            root1=root1.children[index]
        root1.isEnd=True

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        root1=self.root
        for i in range(len(word)):
            index=ord(word[i])-ord('a')
            if root1.children[index]==None:
                return False
            root1=root1.children[index]
        return root1.isEnd
        

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        root1=self.root
        for i in range(len(prefix)):
            index=ord(prefix[i])-ord('a')
            if root1.children[index]==None:
                return False
            root1=root1.children[index]
        return True
        
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)