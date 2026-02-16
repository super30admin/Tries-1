# // Time Complexity : O(l)
# // Space Complexity : O(l)
class Trie:

    
    def __init__(self,value=None):
        self.value = value
        self.isEnd = False
        self.children = [ None for i in range(26)]
     

    def insert(self, word: str) -> None:
        temp = self
        for i in range(len(word)):
            # temp.isEnd = False
            if(temp.children[ord(word[i])-97] is None):
                temp.children[ord(word[i])-97] = Trie(word[i])
            temp = temp.children[ord(word[i])-97]
        temp.isEnd = True

    def search(self, word: str) -> bool:
        temp = self
        for char in word:
            idx = ord(char) - 97
            if temp.children[idx] is None:
                return False
            temp = temp.children[idx]
        return temp.isEnd

    def startsWith(self, prefix: str) -> bool:
        temp = self
        for char in prefix:
            idx = ord(char) - 97
            if temp.children[idx] is None:
                return False
            temp = temp.children[idx]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)