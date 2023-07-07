# Time complexity : O(n*L) n is number of words in dictionary, L is average length of each word
# Space complexity : O(size of dictionary) to store the trie

# TrieNode class to initialize a node with null pointers. Replace the null pointer with an array while inserting a new node.
# End of word flag to check if we reach end of a string
# Traverse through the word to be inserted and update the corresponding array in the Tree
class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.EoW = False

class Trie:

    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        cur = self.root
        for w in word:
            idx = ord(w) - ord('a')
            if cur.children[idx] == None:
                cur.children[idx] = TrieNode()
            cur = cur.children[idx]
        cur.EoW = True

        

    def search(self, word: str) -> bool:
        cur = self.root

        for w in word:
            idx = ord(w) - ord('a')

            if cur.children[idx] == None:
                return False

            cur = cur.children[idx]
        return cur.EoW
        

    def startsWith(self, prefix: str) -> bool:
        cur = self.root

        for w in prefix:
            idx = ord(w) - ord('a')
            
            if cur.children[idx] == None:
                return False
            
            cur = cur.children[idx]

        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
