'''
TC: O(L) - L is the length of the word
SC: O(1) - limited letters in a valid dictionary words
'''
class Node:
    def __init__(self):
        self.children = {}
        self.flag = False

class Trie:

    def __init__(self):
        self.dummy = Node()

    def insert(self, word: str) -> None:
        pointer = self.dummy
        for letter in word:
            if letter not in pointer.children:
                pointer.children[letter] = Node()
            pointer = pointer.children[letter]
        pointer.flag = True

    def search(self, word: str) -> bool:
        pointer = self.dummy
        for letter in word:
            if letter not in pointer.children:
                return False
            pointer = pointer.children[letter]
        return pointer.flag
        

    def startsWith(self, prefix: str) -> bool:
        pointer = self.dummy
        for letter in prefix:
            if letter not in pointer.children:
                return False
            pointer = pointer.children[letter]
        return True
     
# Your Trie object will be instantiated and called as such:
obj = Trie()
obj.insert("apple")
param_2 = obj.search("apple")
param_3 = obj.startsWith("app")
print(param_2)
print(param_3)
param_2 = obj.search("apt")
param_3 = obj.startsWith("apt")
print(param_2)
print(param_3)