# created a hashmap of TrieNode 
# adding each character to hashmap of trie
# last element will be end of world
# time complexity : 0(1) for search , 0(n) to insert, space complexity 0(n) for length of word string

class TrieNode :

    def __init__(self):
        self.children = {}
        self.endOfWord = False

class Trie:

    def __init__(self):
    # initialzing Trie with TrieNode
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        # inserting words into the Trie Node
        cur = self.root

        for c in word :
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
        cur.endOfWord = True


        

    def search(self, word: str) -> bool:
        # searching for word in trie going one by one
        cur = self.root 

        for c in word :
            if not c in cur.children:
                return False
            cur = cur.children[c]

        return cur.endOfWord

        

    def startsWith(self, prefix: str) -> bool:
        # we need to check for prefix 
        cur = self.root

        for c in prefix :
            if c not in cur.children :
                return False
            cur = cur.children[c]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)