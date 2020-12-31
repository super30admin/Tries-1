"""
Apporach: 

We have 26 alphabets in english dictionary. So our trie will work something like this.
1) Every node would be a TrieNode with two properties: i) If its a last character or not ii) It will contain list of 26 children who are also TrieNodes

INSERT:
So when we insert a word, we iterate over every letter in the word and add a TrieNode at its place in the array and move to that TrieNode for further traversal. Also the last node will have its last character property as true

SEARCH:
We start traversing from the root and along with it iterate over the characters of the word we want to find. While checking if at any place we find an empty position, that means we have encountered a new letter at that level. Thus a new word is encountered and we return False.

STARTSWITH:
Its same as search but as soon as we find the prefix we return true and if at any level new letter has encountered we return false.

"""

class TrieNode:
    def __init__(self):
        self.lastChar = False
        self.children = [0] * 26

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        
    # Time complexity: O(n); n = length of word
    # Space complexity: O(n); n = length of word. In worst its possible that the word does not share a prefix
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            if (curr.children[ord(c)-ord('a')] == 0) :
                curr.children[ord(c)-ord('a')] = TrieNode()
            curr = curr.children[ord(c)-ord('a')] 
            
        curr.lastChar = True
    
    # Time complexity: O(n); n = length of word
    # Space complexity: O(1) 
    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            
            # Check if the entire word is present or not. "Apple is present" and "Appleton" is being searched
            if (curr.children[ord(c)-ord('a')] == 0) :
                return False
            
            curr = curr.children[ord(c)-ord('a')]
            
        # If "apple" is present and "app" is being searched. 
        if curr.lastChar:
            return True
        return False
     
    # Time complexity: O(n); n = length of prefix
    # Space complexity: O(1) 
    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for i in range(len(prefix)):
            c = prefix[i]
            
            # Check if the prefix is present or not.
            if (curr.children[ord(c)-ord('a')] == 0) :
                return False
            
            curr = curr.children[ord(c)-ord('a')]
            
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)