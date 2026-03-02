'''
Time Complexity: 
insert O(N) the loop runs for N characters in the word 
search O(N) the loop runs for N characters in the word 
startsWith O(N) the loop runs for N characters in the prefix 

Space Complexity: O(N) the space used by the trie is proportional to the number of characters in the inserted words
'''

class Trie:

    def __init__(self):
        self.trie = {}

    def insert(self, word: str) -> None:
        temp = self.trie
        for char in word:
            if char not in temp:
                temp[char] = {}
            temp = temp[char]
        temp["end"] = True

    def search(self, word: str) -> bool:
        temp = self.trie
        for char in word:
            if char not in temp:
                return False
            temp = temp[char]
        if 'end' not in temp:
            return False
        return True

    def startsWith(self, prefix: str) -> bool:
        temp = self.trie
        for char in prefix:
            if char not in temp:
                return False
            temp = temp[char]
        return True
    
    def printTrie(self):
        print(self.trie)


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
