#Implement Trie (Prefix Tree)

class TrieDataStructure:
    def __init__(self):
        self.charDict={}
        self.endsHere = False

 # Space O(NxL)
class Trie:

    def __init__(self):
        self.TDS = TrieDataStructure()

    # Time O(NxL)
    # Space (O1)
    def insert(self, word: str) -> None:
        currNode = self.TDS
        for char in word:
            if char not in currNode.charDict:
                currNode.charDict[char] = TrieDataStructure()
            currNode = currNode.charDict[char]     
        currNode.endsHere = True
        
    # Time O(L)
    # Space (O1)
    def search(self, word: str) -> bool:
        currNode = self.TDS
        for char in word:
            if char not in currNode.charDict:
                return False
            currNode = currNode.charDict[char]
        return currNode.endsHere

    # Time O(L)
    # Space (O1)
    def startsWith(self, prefix: str) -> bool:
        currNode = self.TDS
        for char in prefix:
            if char not in currNode.charDict:
                return False
            currNode = currNode.charDict[char]
        return True
        
    

obj = Trie()
obj.insert("apple")
print(obj.search("apple"))
print(obj.startsWith("app"))