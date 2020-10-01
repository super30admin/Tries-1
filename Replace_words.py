# time: - O(N+M) N is the number of words and M is every word in the sentence
# space: - O(N) 

class TrieNode:
    def __init__(self):
        self.word = False
        self.children = {}

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.root
        for i in word:
            if i not in node.children:
                node.children[i] = TrieNode()
            node = node.children[i]
        node.word = True
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root
        
        for i in word:
            if i in node.children:
                node = node.children[i]
            else:
                return False
        return node.word
    
    def prefix(self, word: str):
        node = self.root
        prefix = ""
        
        for i in word:
            if i not in node.children:
                return word
            prefix += i
            
            if node.children[i].word == True:
                return prefix
            else:
                node = node.children[i]
        return word
            

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        trie = Trie()
        
        output = []
        for i in dictionary:
            trie.insert(i)
        
        for i in sentence.split(" "):
            output.append(trie.prefix(i))
        
        print(output)
        
        return (" ".join(output))
