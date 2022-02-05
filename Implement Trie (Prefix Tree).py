# Time Complexity :
# TC for insert: O(nl) --> n is number of words in dictionary and l is length of each word
# TC for search: O(l) --> l is length of word to be searched
# TC for insert: O(l) --> l is length of prefix to be searched

# Space Complexity :
# SC: O(nl) --> Space taken by trie

# Did this code successfully run on Leetcode :
# Yes

# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach
class TrieNode:
    
    def __init__(self):
        self.isEnd = False
        self.children = [None for i in range(26)]

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        
        for char in word:
            if curr.children[ord(char) - ord('a')] == None:
                curr.children[ord(char) - ord('a')] = TrieNode()
            curr = curr.children[ord(char) - ord('a')]
        
        curr.isEnd = True

    def search(self, word: str) -> bool:
        curr = self.root
        
        for char in word:
            if curr.children[ord(char) - ord('a')] == None: return False
            curr = curr.children[ord(char) - ord('a')]
            
        return curr.isEnd

    def startsWith(self, prefix: str) -> bool:
        
        curr = self.root
        
        for char in prefix:
            if curr.children[ord(char) - ord('a')] == None: return False
            curr = curr.children[ord(char) - ord('a')]
            
        return True



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)