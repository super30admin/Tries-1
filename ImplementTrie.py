'''
#time complexity: O(len(word))
space complexity: O(1)
'''
class TrieNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isWord = False
        
class Trie:

            
    def __init__(self):
        self.root = TrieNode()
        
    #time complexity: O(len(word)) 
    def insert(self, word: str) -> None:
        curr = self.root
        for w in word:
            if curr.children[ord(w)-ord('a')] == None:
                curr.children[ord(w)-ord('a')] = TrieNode()
            curr = curr.children[ord(w)-ord('a')] 
        curr.isWord = True

    #time complexity: O(len(word))    
    def search(self, word: str) -> bool:
        curr = self.root
        for w in word:
            if(curr.children[ord(w)-ord('a')] == None): return False
            curr = curr.children[ord(w)-ord('a')]
        return curr.isWord
        
    #time complexity: O(len(word))
    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for w in prefix:
            if(curr.children[ord(w)-ord('a')] == None): return False
            curr = curr.children[ord(w)-ord('a')]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)