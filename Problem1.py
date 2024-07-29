#I implemented a Trie data structure with three main methods: insert, startsWith, and search. The insert method adds a word to the Trie by creating a path of nodes for each character, ending with a special marker '*' to signify the end of the word. The startsWith method checks if there is any word in the Trie that starts with a given prefix by traversing the Trie according to the characters in the prefix. The search method verifies if a complete word exists in the Trie by first using startsWith to locate the prefix and then checking for the '*' marker at the end. The time complexity for each operation (insert, startsWith, search) is O(L), where L is the length of the word or prefix being processed. The space complexity is O(N×L), where N is the number of words inserted into the Trie and L is the average length of the words, as each node in the Trie represents a unique character path.

class Trie:

    def __init__(self):
        self.root={}
        
    def insert(self, word: str) -> None:
        cur=self.root
        for c in word:
            if c not in cur:
                cur[c]={}
            cur=cur[c]
        cur['*']=''
        
    def startsWith(self, prefix: str) -> bool:
        cur=self.root
        for c in prefix:
            if c not in cur:
                return 
            cur=cur[c]
        return cur

    def search(self, word: str) -> bool:
        found = self.startsWith(word)
        return found and '*' in found