# Time Complexity : insert,search,prefix- O(len(s))
# Space Complexity : O(number of string * len(strings))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#make is end if the a word exists
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.Childs = [None]*26

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
        
        for i in range(len(word)):
            if node.Childs[ord(word[i]) - 97] == None:
                node.Childs[ord(word[i]) - 97] = TrieNode()
            node = node.Childs[ord(word[i]) - 97]
        node.isEnd = True
        return;

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root
        for i in range(len(word)):
            if node.Childs[ord(word[i]) - 97] == None:
                return False
            node = node.Childs[ord(word[i]) - 97]
        return node.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        for i in range(len(prefix)):
            if node.Childs[ord(prefix[i]) - 97] == None:
                return False
            node = node.Childs[ord(prefix[i]) - 97]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)