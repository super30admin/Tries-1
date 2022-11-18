"""
FAANMG Problem #77 {Medium}

208. Implement Trie (Prefix Tree)

Space complexity : O (n * 26 ^ k)


Did this code successfully run on Leetcode : Yes


@name: Rahul Govindkumar_RN27JUL2022
"""  

class TrieNode:

    # A trie node has 26 places as a list, and a flag
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isEnd_Flag = False  

class Trie:

    # Initalizing the Trie by calling the Trie class
    def __init__(self):
        self.root = TrieNode()

    # Time complexity : O(L) --> L - length of word
    def insert(self, word: str) -> None:

        # starting from root
        curr = self.root
        
        # go till the end of word length
        for i in range(len(word)):
            c = word[i]
            
            # if letter is not present in the trie, make a new node and add it
            if not curr.children[ord(c)-ord('a')]:
                curr.children[ord(c)-ord('a')] = TrieNode()
                
                
            # if we have the character, then we move forward and check
            curr = curr.children[ord(c)-ord('a')]
        
        # marking the end of the word here
        curr.isEnd_Flag = True

       
    # Time complexity : O(L) --> L - length of word
    def search(self, word: str) -> bool:
        
        # start from root and check until the lenght of the word
        curr = self.root
        
        for i in range(len(word)):
            c = word[i]
            
            # if at any point, the list is empty for that character, we return False
            if curr.children[ord(c)-ord('a')] is None:
                return False
            
            curr = curr.children[ord(c)-ord('a')]
            
         # we return the flag, it's true only if the word ends here, otherwise False
        return curr.isEnd_Flag
    
    
    # Time complexity : O(K) --> K - length of prefix
    def startsWith(self, prefix: str) -> bool:
        
        # Start from root and until the end of the given prefix to search
        curr = self.root
        
        for i in range(len(prefix)):
            c = prefix[i]
            
            # check if the char is present in Trie
            # if present, move to the next character until the prefix lenght is complete
            if curr.children[ord(c)-ord('a')]:
                curr = curr.children[ord(c)-ord('a')]
            else:
              # return False is any one char is not matching
                return False
        # else return True
        return True        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)