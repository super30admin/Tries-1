"""
    Student : Shahreen Shahjahan Psyche
              
    Pased Test Cases : Yes
    
"""

class Node:
    def __init__(self):
        self.isEnd = False
        self.records = [None for i in range(26)]

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.head = Node()
        
        
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        current = self.head
        for i in range(len(word)):
            pos = ord(word[i]) - ord("a")
            if current.records[pos]:
                current = current.records[pos]
            else:
                newNode = Node()
                current.records[pos] = newNode
                current = current.records[pos]
        current.isEnd = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        current = self.head
        for i in range(len(word)):
            pos = ord(word[i]) - ord("a")
            if current.records[pos]:
                current = current.records[pos]
            else:
                return False
        
        if current.isEnd:
            return True
        else:
            return False
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        
        current = self.head
        for i in range(len(prefix)):
            pos = ord(prefix[i]) - ord("a")
            if current.records[pos]:
                current = current.records[pos]
            else:
                return False
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
