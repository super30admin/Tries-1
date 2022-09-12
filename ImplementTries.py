

class TrieNode():
    #Decalre children and a flag to denote end of string
    def __init__(self):
        self.children = {}
        self.isEnd = False
class Trie:

    def __init__(self):
        self.root = TrieNode()
    #Traverse through child and mark true if it reaches the end
    def insert(self, word: str) -> None:
        curr = self.root
        for i in word:
            if i not in curr.children:
                curr.children[i] = TrieNode()
            curr = curr.children[i]
        curr.isEnd = True
        
    #The search function traverse through the children and return the flag to true or false accordingly
    def search(self, word: str) -> bool:
        curr = self.root
        for i in word:
            if i not in curr.children:
                return False
            curr = curr.children[i]
        return curr.isEnd
            
    #Similar to search but return true at end case insted of our flag
    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in prefix:
            if i not in curr.children:
                return False
            curr = curr.children[i]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)