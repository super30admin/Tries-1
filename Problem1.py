# Time Complexity :O(n) where n is len of word
# Space Complexity : O(nl)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


class TrieNode(object):
    def __init__(self):
        self.isEnd = False
        self.children = [None]*26


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
        curr = self.root

        for i in word:
            temp = ord(i) - ord('a')
            if curr.children[temp] == None:
                curr.children[temp] = TrieNode()
            curr = curr.children[temp]
        curr.isEnd = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for i in word:
            temp = ord(i)-ord('a')
            if curr.children[temp] == None:
                return False
            curr = curr.children[temp]
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for i in prefix:
            temp = ord(i)-ord('a')
            if curr.children[temp] == None:
                return False
            curr = curr.children[temp]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
