#time O(N)
#space O(N)

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.trie={}
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        temp=self.trie
        for i in word:
            if i not in temp:
                temp[i]={}
            temp=temp[i]
        temp['<END>'] = True
        # print(self.trie)
   

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        temp=self.trie
        for i in word:
            if i not in temp:
                return False
            temp=temp[i]
        return '<END>' in temp

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        temp=self.trie
        for i in prefix:
            if i not in temp:
                return False
            temp=temp[i]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)