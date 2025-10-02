'''
Time Complexity:
    - insert: O(L) , L = length of word
    - search: O(L)
    - startswith: O(L)
Space Complexity: O(N*L), N = number of words, L = Average Length of word

'''
class TrieNode:
    def __init__(self):
        self.isWord = False
        self.children = None

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None: 
        node = self.root
        for ch in word:
            if node.children==None:
                node.children = [None]*26
            if node.children[ord(ch)-ord('a')] == None:
                node.children[ord(ch)-ord('a')] = TrieNode()
            node = node.children[ord(ch)-ord('a')]
        node.isWord = True
        
    def search(self, word: str) -> bool:
        node = self.root
        for ch in word:
            if node.children==None:
                return False
            if node.children[ord(ch)-ord('a')] == None:
                return False
            node = node.children[ord(ch)-ord('a')]
        
        return node.isWord

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for ch in prefix:
            if node.children==None:
                return False
            if node.children[ord(ch)-ord('a')] == None:
                return False
            node = node.children[ord(ch)-ord('a')]
        
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)