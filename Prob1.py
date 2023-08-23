class TrieNode:
    def __init__(self): #create a TrieNode class with End of word boolean parameter and a size 26 array for each element
        self.Eow=False
        self.children=[None for _ in range(26)]


class Trie:

    def __init__(self):
        self.root=TrieNode() #intiate the root

    def insert(self, word: str) -> None:
        cur=self.root
        for char in word:
            idx=ord(char)-ord('a') #get index in number
            if cur.children[idx]==None: #if empty, create a new TrieNode
                cur.children[idx]=TrieNode()
            cur=cur.children[idx] #go to next child node in the tree
        cur.Eow=True #after appending new word, make the last node's EOW true

    def search(self, word: str) -> bool:
        cur=self.root
        for char in word:
            idx=ord(char)-ord('a') #get index in number
            if cur.children[idx]==None: #if empty, it doesn't exsit, return 
                return False
            cur=cur.children[idx] #go to next child node in the tree
        return cur.Eow #return last element of the word's node's EOW -> captain exists but cap doesn't, so when searched for cap it should return False, even though the approprotate letters exist cause of "captain"

    def startsWith(self, prefix: str) -> bool:
        cur=self.root
        for char in prefix:
            idx=ord(char)-ord('a') #get index in number
            if cur.children[idx]==None: #if empty, it doesn't exsit, return 
                return False
            cur=cur.children[idx]
        return True #if we reach of the prefix -> it exists
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)