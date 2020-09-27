"""
    // Time Complexity :O(nk)
    // Space Complexity :O(nk)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NA

    //Explanation:
    the TrieNode is initialized as array of 26 characters(only lower letter alphabets)
    isEnd is set to True when complete word is inserted into Trie; for the rest of alphabets
    it is False

"""
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for i in range(26)]
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
        for i in range(len(word)):
            index = ord(word[i]) - ord('a')
            if current.children[index] == None:
                current.children[index] =TrieNode()
            current = current.children[index]
        current.isEnd = True   # end of the word


    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        current = self.root
        for i in range(len(word)):
            index = ord(word[i]) - ord('a')
            if current.children[index] == None:
                return False
            current = current.children[index]
        return current.isEnd



    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        current = self.root
        for i in range(len(prefix)):
            index = ord(prefix[i]) - ord('a')
            if current.children[index] == None:
                return False
            current = current.children[index]
        return True




# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
