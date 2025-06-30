#Time Complexity O(NxK) where k is avg length of words 
#Space Complexity O(M) where M is sum of lengths of all words
#Approach 
  # - What if we use common prefixes istead of  using diff places for storing 
  # -  We have root which is dict d[char]=TrieNode for every node we have max 26 keys also we have is_End to store if thats end of word or not
  # -  Search is just travesing through dicts of dicts and checking is_end
  #-  Worst case would be all words with diffrent prefixes



class TrieNode:
    def __init__(self):
        self.children={}
        self.is_end=False


class Trie:

    def __init__(self):
        self.root=TrieNode()
        

    def insert(self, word: str) -> None:
        curr=self.root
        for i in word:
            if i not in curr.children:
                curr.children[i]= TrieNode()

            curr=curr.children[i]
        curr.is_end=True
        

    def search(self, word: str) -> bool:
        curr=self.root
        for i in word:
            if i not in curr.children:
                return False

            curr=curr.children[i]
        return curr.is_end
        

    def startsWith(self, word: str) -> bool:
        curr=self.root
        for i in word:
            if i not in curr.children:
                return False

            curr=curr.children[i]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
