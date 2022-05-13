#implement trie
# // Time Complexity :  O(N) - n is the length of the word
# // Space Complexity : O(N) - N is the length of the word
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Trie:
    class TrieNode:                             #making the trie node class with its children and isend method
        def __init__(self):
            self.children = [None]*26
            self.is_end=False
    
    

    def __init__(self):
        self.node = self.TrieNode()
        
        

    def insert(self, word: str) -> None:                            #inserts the words, letter by letter to the trie node by setting the ascii of the letter to a trie node, instead of None
        current = self.node
        for i in range(len(word)):
            if (current.children[ord(word[i])-97]):
                pass
            else:
                current.children[ord(word[i])-97] = self.TrieNode()
            
            current = current.children[ord(word[i])-97]
        current.is_end= True
        

    def search(self, word: str) -> bool:                                    #checks the trie node for the word and if its there, returns the value of is_end, else, returns true
        current = self.node
        for i in range(len(word)):
            if (current.children[ord(word[i])-97]):
                current = current.children[ord(word[i])-97]
            else:
                return False
        return current.is_end
        

    def startsWith(self, prefix: str) -> bool:                          #just returns if the prefix is there, if not false
        current = self.node
        for i in range(len(prefix)):
            if (current.children[ord(prefix[i])-97]):
                current = current.children[ord(prefix[i])-97]
            else:
                return False
        return True