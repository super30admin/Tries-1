"""
I implemented a Trie (prefix tree) using a TrieNode class that holds an array of 26 children (for each lowercase letter) and a flag to mark the end of a word. The insert method adds characters node by node, creating new nodes when needed. The search method checks if a word exists in the Trie, and startsWith verifies if any word starts with a given prefix. This approach ensures efficient word and prefix lookups in linear time.
Time Compelxity: O(n) where n is length of the word for each function
Space Compelxity: O(mn) where m is the number of words and n is length of the word
"""
class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.endFlag = False
 
class Trie:

    def __init__(self):
        self.root = TrieNode()
    
    def charToIndex(self, ch):
        return ord(ch) - ord('a')

    def insert(self, word: str) -> None:
        curr = self.root
        for char in word:
            index = self.charToIndex(char)
            if not curr.children[index]:
                curr.children[index] = TrieNode()
            curr = curr.children[index]
        curr.endFlag = True    

    def search(self, word: str) -> bool:
        curr = self.root
        for char in word:
            index = self.charToIndex(char)
            if not curr.children[index]:
                return False
            curr = curr.children[index]
        return curr.endFlag

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for char in prefix:
            index = self.charToIndex(char)
            if not curr.children[index]:
                return False
            curr = curr.children[index]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)