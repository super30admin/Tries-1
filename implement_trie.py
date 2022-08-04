#Approach:
# Insert - To insert a word, first traverse trie to find any prefix available and append the remaining string. 
#TC- O(N) , SC- O(1) user space
#Search - Traverse the trie and see if the char exists and return isend- will be true if we reach end of string
#TC- O(N), SC- O(1)
#Start with- It looks for prefix in the trie, here we do the same thing as search() except here we don't need to check if the word is complete or not, i.e. isEnd, just run the loop till the end of the string

class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isend = False
        self.val = None
    
class Trie:
    
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for char in word:
            ci = ord(char) - ord('a')
            if curr.children[ci] == None:
                curr.children[ci] = TrieNode()
                curr.children[ci].val = char
            curr = curr.children[ci]
        curr.isend = True
            

    def search(self, word: str) -> bool:
        curr = self.root
        for char in word:
            ci = ord(char) - ord('a')
            if curr.children[ci] == None:
                return False
            curr = curr.children[ci]
        return curr.isend

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for char in prefix:
            ci = ord(char) - ord('a')
            if curr.children[ci] == None:
                return False
            curr = curr.children[ci]
        return True
        



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)