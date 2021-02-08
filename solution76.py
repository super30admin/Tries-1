#Time Complexity:O(n)
#SPace Complexity:O(n)

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False
        
class Trie:
   
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root=TrieNode()                                                #Create a trienode root
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root                                                    #initalize curr to root
        for i in range(len(word)):
            c=word[i]                                                       #iterate through the word characters one by one
            if curr.children[ord(c) - ord("a")] == None:                    #if the characters dont exists in trie create a trienode for same and insert the character
                curr.children[ord(c) - ord("a")] = TrieNode()
            curr = curr.children[ord(c) - ord("a")]
        curr.isEnd = True                                                   #make the current node an end node
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root                                                    #initalize curr to root
        for i in range(len(word)):                                          #iterate through the word characters one by one
            c=word[i]                                                       #if the characters dont exists in trie create a trienode for same and insert the character
            if curr.children[ord(c) - ord("a")] == None: return False
            curr = curr.children[ord(c) - ord("a")]
        return curr.isEnd                                                   #if current node is end node it will return True else false

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root                                                    #initalize curr to root
        for i in range(len(prefix)):                                        #iterate through the word characters one by one
            c=prefix[i]                                                     #if the characters dont exists in trie create a trienode for same and insert the character
            if curr.children[ord(c) - ord("a")] == None: return False
            curr = curr.children[ord(c) - ord("a")]
        return True                                                         #Parse through the word and if the word exists return true . If the word character does not exists return false
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)