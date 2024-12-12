"""
Insert all the words in dictionary into Trie, search for the shortest prefix
TC: O(n*k) + O(s*k) for Trie insertion, n- number of words in dicionary , k avg length of each word, s number ords in the given sentence
SP: O(n*k) + O(s*k) to store all the words

"""
class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False
class Trie:
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            if curr.children[ord(c)-ord('a')] == None:
                curr.children[ord(c)-ord('a')] = TrieNode()
            curr = curr.children[ord(c)-ord('a')]
        curr.isEnd = True
        
    def shortest_root(self, word: str) -> bool:
        curr = self.root
        
        for i, c in enumerate(word):
            if curr.children[ord(c)-ord('a')] == None:
                return word
            curr = curr.children[ord(c)-ord('a')]
            if curr.isEnd:
                return word[:i+1]
        return word


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:

        pref_tree = Trie()
        for word in dictionary:
            pref_tree.insert(word)
        sentence = sentence.split()

        for i, word in enumerate(sentence):
            sentence[i] =  pref_tree.shortest_root(word)

        return " ".join(sentence)

            
        