#Approach
#Create a trie node and loop through the character in the string. Every trie has a flag which tells the end of string.


#Complexities
#Time : O(N*L)
#Space : O(1)




class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        temp = self.root
        for char in word:
            if temp.children[ord(char) - ord('a')] == None:
                node = TrieNode()
                temp.children[ord(char) - ord('a')] = node
            temp = temp.children[ord(char) - ord('a')]
        temp.isEnd = True

    def search(self, word: str) -> bool:
        temp = self.root
        for char in word:
            if temp.children[ord(char) - ord('a')] == None:
                return False
            else:
                temp = temp.children[ord(char) - ord('a')]

        return temp.isEnd

    def startsWith(self, prefix: str) -> bool:
        temp = self.root
        for char in prefix:
            if temp.children[ord(char) - ord('a')] == None:
                return False
            temp = temp.children[ord(char) - ord('a')]

        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)