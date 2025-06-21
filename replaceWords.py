"""
Build a Trie from all root words
For each word in the sentence, search the Trie for shortest matching prefix
If found, replace the word with the prefix ; else keep the original
"""
"""
Time Complexity: Build Trie: O(D × L) (D = number of roots, L = average root length)
Replace Words: O(W × L) (W = number of words in sentence) 
Space Complexity:O(D × L) for the Trie
"""


from typing import List

class TrieNode:
    def __init__(self):
        self.children = {}
        self.end = False 

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str):
        node = self.root
        for ch in word:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            node = node.children[ch]
        node.end = True

    def search_root(self, word: str) -> str:
        node = self.root
        prefix = ""
        for ch in word:
            if ch not in node.children:
                return word  
            node = node.children[ch]
            prefix += ch
            if node.end:
                return prefix  
        return word  

class replaceWords:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for root in dictionary:
            trie.insert(root)

        words = sentence.split()
        replaced = [trie.search_root(word) for word in words]
        return " ".join(replaced)


if __name__ == "__main__":
    obj = replaceWords()
    dictionary = ["cat", "bat", "rat"]
    sentence = "the cattle was rattled by the battery"
    print(obj.replaceWords(dictionary, sentence))

