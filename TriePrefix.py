# TC: O(L) all operations
# SC: O(L) L-length of the word 

# We define each node with isEnd flag to indicate end of word and children array of 26 chars 
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26

class Trie:
    # new node creation
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word: str) -> None:
        # start from root
        curr = self.root
        # check for each char of word if it exits already in the sequence, start creating sequence of nodes when a char doesnt exist
        for i in range(len(word)):
            ch = word[i]
            if curr.children[ord(ch)-ord('a')] == None:
                curr.children[ord(ch)-ord('a')] = TrieNode()
            # move pointer to its child node as found/created in prev step 
            curr = curr.children[ord(ch)-ord('a')]
        # mark end of word after loop ends
        curr.isEnd = True
        
    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            if curr.children[ord(ch)-ord('a')] == None: return False
            curr = curr.children[ord(ch)-ord('a')]
        # return isEnd. For word to exist, isEnd should be true at the last char node of the word
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(len(prefix)):
            ch = prefix[i]
            if curr.children[ord(ch)-ord('a')] == None: return False
            curr = curr.children[ord(ch)-ord('a')]
        # prefix, we need not worry for isEnd check, return True if above loop is not broken
        return True