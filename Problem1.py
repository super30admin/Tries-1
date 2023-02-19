# Time Complexity  :- O(n) for all 3 method  where n is length of the word 
# Space Complexity : - O(1) no extra space just creation of TrieNode 
# Approach :- HashMap

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = {}


class Trie:

    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        curr = self.root
        for letter in word:
            if letter not in curr.children:
                curr.children[letter] = TrieNode()
            curr = curr.children[letter]
        curr.isEnd = True



    def search(self, word: str) -> bool:
        curr = self.root
        for letter in word:
            if letter not in curr.children:
                return False
            curr = curr.children[letter]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for letter in prefix:
            if letter not in curr.children:
                return False
            curr = curr.children[letter]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)


## Approach :- List 
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = []
        for i in range(27):
            self.children.append(None)


class Trie:

    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            if curr.children[ord(word[i])-ord('a')] == None:
                curr.children[ord(word[i])-ord('a')] = TrieNode()
            curr = curr.children[ord(word[i])-ord('a')]
        curr.isEnd = True



    def search(self, word: str) -> bool:
        curr = self.root
        for i in range(len(word)):
            if curr.children[ord(word[i])-ord('a')] == None:
                return False
            curr = curr.children[ord(word[i])-ord('a')]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(len(prefix)):
            if curr.children[ord(prefix[i])-ord('a')] == None:
                return False
            curr = curr.children[ord(prefix[i])-ord('a')]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)