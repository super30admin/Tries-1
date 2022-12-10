#Time complexity: insert: O(n), search: O(n), startsWith o(n) where O is the length of the word
#Space complexity: O(n) for insert, constant for the other two

#Accepted on Leetcode

#Approach
#Construct a Trie with TrieNode object, each object has a nodeArr (length 26) to symbolize the character set ('a'-'z') and an isEnd variable
#Initialize Trie with a root TrieNode
# (1)Insert by Traversing via root of the Trie tree and then searching incrementally for character (match it with 0-26 of the array of the node), (2)same for search(use isEnd to confirm if word exists), (2)same for prefix (no need to use isEnd)

class TrieNode:
    def __init__(self):
        self.nodeArr = [None for i in range(26)]
        self.isEnd = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        root = self.root
        for char in word:
            numVal = ord(char) - ord('a') # 0 to 26 representation
            if root.nodeArr[numVal] == None: #prefix does not exist
                root.nodeArr[numVal] = TrieNode()
            root = root.nodeArr[numVal]

        root.isEnd = True



    def search(self, word: str) -> bool:
        root = self.root
        for char in word:
            numVal = ord(char) - ord('a')
            if root.nodeArr[numVal] == None:
                return False
            root = root.nodeArr[numVal]
        
        return root.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        root = self.root
        for char in prefix:
            numVal = ord(char) - ord('a')
            if root.nodeArr[numVal] == None:
                return False
            root = root.nodeArr[numVal]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)